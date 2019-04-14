import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

  public static void main(String[]args) throws IOException {
    // 获取同义词
    Thesaurus thesaurusObject=new Thesaurus();
   List<Map<String,String>> thesList=thesaurusObject.thesaurus("D:/softDd/ansj/thesaurus.txt");
   final Map<String,String> thesL=thesList.get(0);
   final Map<String,String> thesR=thesList.get(1);
    // 结果
    String resultString ="";
    // 文本输入框
    final JTextField[] input = {new JTextField()};//new一个文本框
    final JTextArea output=new JTextArea(); //new一个文本区
    String title = "请将复制内容粘贴到文本框中（粘贴好后直接回车即可）";
    JFrame jf=new JFrame(title);
    Container container=jf.getContentPane();
    //container.setBackground(Color.yellow);   //容器的背景色
    jf.setVisible(true);//窗体可见
    jf.setSize(600, 400);//窗体大小
    jf.setLayout(new BorderLayout()); //边界布局
    jf.add(BorderLayout.NORTH, input[0]);//文本框边界顶部放置
    input[0].setBackground(Color.yellow);
    jf.add(BorderLayout.CENTER,output);//文本框边界中间放置
    output.setBackground(Color.blue);

    // 输出
    input[0].addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // 主要逻辑
        // 获取文本框内容
        String finalResultString = "";
        String content= input[0].getText();
        try {
          // 分词
          AnsjParticiples ansjParticiples=new AnsjParticiples();
          List<String> ansjWords=ansjParticiples.ansjSegmentationWords(content);
          // 同义词替换
          int count =0;
          for(String aw:ansjWords ){
            // 判断左列
            if(thesL.containsKey(aw)){
              ansjWords.set(count,thesL.get(aw));
            }
            // 判断右列
            if(thesR.containsKey(aw)){
              ansjWords.set(count,thesR.get(aw));
            }
            count=count+1;
          }
          // 获得最终替换结果
          String s="";
          for(String value:ansjWords){
            s=s+value;
          }
          finalResultString=s;
        }
        catch (UnsupportedEncodingException e1) {
          e1.printStackTrace();
        }

        output.setText(finalResultString);
      } //监听器
    });
  }
}
