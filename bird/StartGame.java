package flyingbird;

import javax.swing.*;

/**
 * 游戏入口
 * javax.swing 图形界面设计技术
 */
    public class StartGame {
    public static void main(String[] args) {
//        绘制游戏窗口
        JFrame frame=new JFrame("飞翔的小鸟");
//        设置窗口大小
        frame.setSize(400,670);
//        布局样式--居中(null)
        frame.setLocationRelativeTo(null);
//        关闭应用程序
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        创建画板对象
        BirdGame game=new BirdGame();
//        添加画板
        frame.add(game);

//        添加可视化窗口
        frame.setVisible(true);
//        开始游戏
        game.action();
    }
}
