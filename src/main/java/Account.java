public class Account{
 public synchornized void draw(double drawAmount){
     try{
         //flag == false，表名账户中还没有人存钱进去，则取钱方法阻塞
         if (!flag){
             wait();
         } else{
             //....取钱
             flag = false;
             notifyAll();
         }
     }
 }
 public synchornized void deposit(double depositAmount){
     try{
         //flag == true, 表明账户已有人存钱进去，则存钱方法阻塞
         if (flag){
            wait();
         } else{
             //...存款
             flag = true;
             notifyAll();
         }

     }
 }

}