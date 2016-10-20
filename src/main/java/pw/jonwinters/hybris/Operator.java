package pw.jonwinters.hybris;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2016/10/20 0020.
 */
public class Operator {
    List<BaseRepository> baseRepositoryList;

    private void  init() {
        BaseRepository baseRepositoryw1 = new BaseRepository("w1",1,2,2,1,1);
        BaseRepository baseRepositoryw2 = new BaseRepository("w2",2,1,2,2,2);
        BaseRepository baseRepositoryw3 = new BaseRepository("w3",1,3,1,2,3);
        baseRepositoryList = new ArrayList<BaseRepository>();
        baseRepositoryList.add(baseRepositoryw1);
        baseRepositoryList.add(baseRepositoryw2);
        baseRepositoryList.add(baseRepositoryw3);
    }
    private static int id = 1;//出货单号
    public void operatorRepository(String productName,int productNumber){
        init();
        sort(baseRepositoryList,productName);
        int total = 0;
        int index = 1;//所需要的仓库的个数 按排序 默认至少一个仓库
        for(BaseRepository baseRepository : baseRepositoryList){
            System.out.println(baseRepository);
            total += baseRepository.getProductNumberByName(productName);
            if (total >= productNumber){
                break;
            }else{
                index++;
            }
        }
        printHeader();

        for(int i=0 ; i < index ; i++){//针对每个仓库进行出货
            BaseRepository current = baseRepositoryList.get(i);
            while(productNumber !=0){
                productNumber--;
                if (current.getProductNumberByName(productName) > 0) {
                    current.setProductNumberByName(productName, current.getProductNumberByName(productName) - 1);
                    print(productName,current.getName(),1);
                    if (current.getProductNumberByName(productName)==0){
                        break ;
                    }
                }
            }
        }
    }

    private  void sort(List<BaseRepository> baseRepositoryList,String productName){
        ComparatorForRepository comparatorForRepository = new ComparatorForRepository(productName);
        Collections.sort(baseRepositoryList,comparatorForRepository);
    }
    private void printHeader(){
        System.out.println("发货单号 商品名称 数量 出货仓库");
    }
    private void print(String productName ,String repositoryName ,int number){

        String space = "          ";
        System.out.println(id+space+productName+space+number+space+repositoryName);
        id++;
    }

}
