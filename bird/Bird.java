package flyingbird;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 小鸟类：1.先声明2.初始化3.在画板上画画
 */
public class Bird {
//    小鸟当前状态图片
    public BufferedImage bImage;
//    所有状态的图片(0-7)
    public BufferedImage bImages[];
//    高度，宽度
    int height,width;
//    坐标
    int x,y;
//   初始位置的下标
    int index=0;
//   初始速度
    double v=0;
//   上抛速度
    double upSpeed=15;
//   重力加速度(小鸟默认往下掉的速度)
    double g=4;
//   位移时间
    double t=0.2;
//    小鸟位移
    double s=0;
    public Bird(){
        try {
            bImage= ImageIO.read(getClass().getResource("0.png"));
//            创建长度为8的数组，并且存储所欲图片
            bImages=new BufferedImage[8];
//            依次往里面放图片
            for(int i=0;i<bImages.length;i++){
                bImages[i]=ImageIO.read(getClass().getResource(i+".png"));
//                bImages[i]=ImageIO.read(getClass().getResource("6flowerhead.png"));
            }
//           小鸟位置
            x=120;
            y=220;
//            小鸟的宽高
            width=bImage.getWidth();
            height=bImage.getHeight();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("图片未找到");
        }
    }
//    小鸟飞
    public void fly(){
//       连续访问0~7张图片(变成小数)
        bImage=bImages[index/10%8];
        index++;
    }
//    小鸟上升(点击鼠标，小鸟向上飞)
    public void up(){
        v=upSpeed;
    }
//    小鸟下降(主要控制小鸟移动)
    public void down(){
//        位移s=上升的距离(v*t)-下降的距离(1/2*g*t*t)自由落体运动物体落下的距离
        s=v*t-g*t*t/2;
//        速度(竖直上抛公式vt=v0-gt)
//        v0:向上匀速直线运动的速度 gt: 自由落体运动的速度
        v=v-g*t;
//        y轴移动的距离
        y=y-(int)s;
    }
}
