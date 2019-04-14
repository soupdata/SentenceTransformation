import org.ansj.splitWord.analysis.ToAnalysis;

public class SentenceTransformation {

  public static void main(String[]args){

  }
  // 句式转换
  // 被动变主动
  public String sentenceTransformation(String sentence){
    String result="深度学习的本质，是构造具有很多层隐层的机器学习模型和海量数据的训练，从而学习更有用的特征，" +
      "最终达到提升分类或预测的准确性。所以说，“深度模型”是一种类似手段的存在，“特征学习”是我们想要达到的目的。" +
      "深度学习强调了模型结构的深度，突出了特征学习的重要性，通过逐层特征变换，将样本在原空间的特征表示变换到一个新特征空间，从而使分类或预测更加容易。" +
      "与人工规则构造特征的方法相比，利用大数据来学习特征，更能够刻画数据的丰富内在信息。";
    ToAnalysis.parse(result);
    return result;
  }
}
