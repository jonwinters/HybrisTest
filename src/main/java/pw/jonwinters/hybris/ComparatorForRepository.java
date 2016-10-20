package pw.jonwinters.hybris;

import java.util.Comparator;

/**
 * Created by Administrator on 2016/10/20 0020.
 */
public class ComparatorForRepository implements Comparator<BaseRepository>{

    private String productName;
    public ComparatorForRepository(String productName) {
        this.productName = productName;
    }

    public int compare(BaseRepository o1, BaseRepository o2) {
        if ( o1.getProductNumberByName(productName) == o2.getProductNumberByName(productName) ){
            if (o1.getDistance() == o2.getDistance()){//产品数量相等且距离相等
                return o1.getPriority() - o2.getPriority();//按优先级排序
            }else{//产品数量相等 但是距离不相等 按距离排序 //升序排序
                return o1.getDistance() - o2.getDistance();
            }
        }else{//产品数量不相等
            return o2.getProductNumberByName(productName) - o1.getProductNumberByName(productName);//降序
        }
    }
}
