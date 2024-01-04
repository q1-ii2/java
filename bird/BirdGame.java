package flyingbird;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 画板类(游戏操作类)
 */
public class BirdGame extends JPanel {
//    绘制背景图片(BufferedImage图片缓冲区)
    public BufferedImage bg;
//    绘制开始和结束图片
    public BufferedImage sImage,gImage;
//    游戏状态
    int state;
//    定义规范
    public static final int START=0;
    public static final int RUNNING=1;
    public static final int END=2;
//   声明地面
    public Ground ground;
//   声明小鸟
    public Bird bird;
//    声明管道(用来存放两个管道)
    public Column columns[];
//    定义积分
    int score=0;
    //    赋值
    public BirdGame(){
        try {
            state=START;
//            创建ground对象，调用Ground类
            ground=new Ground();
//            创建小鸟对象
            bird=new Bird();
//            创建管道数组，赋予长度
            columns = new Column[2];
//            创建第一个管道对象 count=0
            columns[0]=new Column();
//            创建第二个管道对象 count=1
            columns[1]=new Column();
//            异常：程序在运行时发生不可控的事件
//            getClas().getResource()获取资源路径
            bg = ImageIO.read(getClass().getResource("bg.png"));
            sImage = ImageIO.read(getClass().getResource("start.png"));
            gImage = ImageIO.read(getClass().getResource("gameover.png"));

//            创建个鼠标适配器，一点击鼠标就触发时间
//            匿名内部类：只能用一次 用法：接口/抽象类/具体类
            MouseAdapter adapter=new MouseAdapter(){
                public void mouseClicked(MouseEvent e){
                    switch(state){
                        case START:
                            state=RUNNING;
                            break;
                        case RUNNING:
                            bird.up();
                            break;
                        case END:
                            state=START;
//                           初始化数据--重新开始游戏
                            bird.x=120;
                            bird.y=220;
                            bird.v=0;
//                           初始化管道
                            Column.count=0;
                            columns[0]=new Column();
                            columns[1]=new Column();
//                           初始化积分
                            score=0;
                            break;
                    }
                }
//                把鼠标适配器装到监听器中
            };
                this.addMouseListener(adapter);
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("图片未找到！");
        }
    }
//    画画(Graphics 画笔)
    public void paint(Graphics g){
        g.drawImage(bg,0,0,null);
//        g.drawImage(ground.image,ground.x,ground.y,null);
        g.drawImage(bird.bImage,bird.x,bird.y,null);
        switch(state){
            case START:
                g.drawImage(sImage,0,0,null);
                break;
            case RUNNING:
                g.drawImage(columns[0].cImage,columns[0].x,columns[0].y,null);
                g.drawImage(columns[1].cImage,columns[1].x,columns[1].y,null);
                break;
            case END:
                g.drawImage(gImage,0,0,null);
                break;
        }
        g.drawImage(ground.image,ground.x,ground.y,null);
//        调用积分
        setScore(g);
    }
//    游戏开始
    public void action(){
//        来回进行滚动---死循环
        while(true){
            switch(state){
                case START:
                    ground.step();
                    bird.fly();
                    break;
                case RUNNING:
                    ground.step();
                    bird.fly();
                    bird.down();
                    if(isHitGround()){
                        state=END;
                        break;
                    }
//                    检测碰到的究竟是哪一根管道
                    for(int i=0;i<columns.length;i++){
                        Column column=columns[i];
//                        调用管道移动方式
                        column.step();
//                    如果碰到游戏结束
                    if(isHitColumn(column)){
                        state=END;
                        break;
                        }
//                    判断小鸟飞过管道
                    if(bird.x==column.x+bird.width){
                        score++;
                    }
               }
//                    columns[0].step();
//                    columns[1].step();
                    break;
                case END:
                    break;
            }
//          让地面一直动起来，重新绘制，一直进行循环
            repaint();
//          控制速度
            try {
//                控制速度(让线程休眠 毫秒数)
                Thread.sleep(1000/60);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }
    }
//    小鸟碰地面(检查小鸟是否碰撞地面，没碰--false，碰到--true）
    public boolean isHitGround(){
        if(bird.y<500-bird.height){
            return false;
        }else{
            return true;
        }
    }
//    小鸟触碰管道
//    1.先考虑小鸟x轴与管道x轴之间的关系
//    2.考虑y轴是否穿过间隙
    public boolean isHitColumn(Column column){
//        先考虑x轴:
//        左边小鸟x>=管道x轴-小鸟宽度
//        右边小鸟x<=管道x轴+管道宽度
        if((bird.x>=column.x-bird.width)&&
                (bird.x<=column.width+column.x)){

//            后考虑y轴：
//            上边：小鸟y轴<=管道y+半个管道的长度(管道总长度/2-管道缝隙)
//            下边：小鸟y轴>=管道y+管道总长度/2+管道缝隙/2-小鸟图片高度
            if((bird.y<=column.y+column.height/2- column.gap/2)
                ||(bird.y>=column.y+column.height/2+column.gap/2-bird.height)){
//                小鸟碰到管道
                return true;
            }else{
                return false;
            }

        }else return false;
    }
//    积分统计
    public void setScore(Graphics g){
        //    字体样式
        Font font=new Font(Font.SERIF, Font.ITALIC,40);
        g.setFont(font);
//        颜色
        g.setColor(Color.white);
        g.drawString(score+" ",40,60);
    }

}
