import org.ansj.domain.Result;
import org.ansj.splitWord.analysis.ToAnalysis;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AnsjParticiples {
  // 分词获取[]
public List<String> ansjSegmentationWords(String sentence) throws UnsupportedEncodingException {
  List<String> oneWords=new ArrayList<String>();
  Result result = ToAnalysis.parse(sentence);
  Iterator iter = result.iterator();
  while (iter.hasNext()) {
    String [] arr=iter.next().toString().split("/");
    // 包括符号
    if(arr.length>=1){
      oneWords.add(arr[0]);
    }

  }
  return oneWords;

}
}
