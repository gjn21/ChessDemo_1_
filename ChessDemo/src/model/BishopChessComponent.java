package model;

import view.ChessboardPoint;
import controller.ClickController;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BishopChessComponent  extends ChessComponent {
    private static Image BISHOP_WHITE;
    private static Image BISHOP_BLACK;

    private Image bishopImage;

    public void loadResource() throws IOException {
        if (BISHOP_WHITE== null) {
            BISHOP_WHITE= ImageIO.read(new File("ChessDemo/images/bishop-white.png"));
        }

        if (BISHOP_BLACK== null) {
            BISHOP_BLACK= ImageIO.read(new File("ChessDemo/images/bishop-black.png"));
        }
    }

    private void initiateBishopImage(ChessColor color) {
        try {
            loadResource();
            if (color == ChessColor.WHITE) {
                bishopImage =BISHOP_WHITE ;
            } else if (color == ChessColor.BLACK) {
                bishopImage =BISHOP_BLACK ;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BishopChessComponent(ChessboardPoint chessboardPoint, Point location, ChessColor color, ClickController listener, int size) {
        super(chessboardPoint, location, color, listener, size);
        initiateBishopImage(color);
    }


    /**
     *这边接下来就是写象的运动。
     *
     *
     * 就在这边
     *那个开头的报错你写完这个bishop的运动之后就会消失
     *
     *
     * @param
     */

    public boolean canMoveTo(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        ChessboardPoint source = getChessboardPoint();
        int x=source.getX();
        int y=source.getY();//x,y 是初始点，x1是重点，diagnol是对角线和
        int x1= destination.getX();
        int y1= destination.getY();
        if (x+y==x1+y1){
            int diagonal =x+y;
            for(int moving=Math.min(x,x1)+1;moving <Math.max(x,x1);moving++){
                if(!(chessComponents[moving][diagonal-moving]instanceof  EmptySlotComponent)){
                    return false;
                }
            }
        }else if (Math.abs(x-y)==Math.abs(x1-y1)){
            int diagnal1=Math.abs(x-y);
            for (int moving1=Math.min(x,x1);moving1<Math.max(x,x1);moving1++){
                if (!((chessComponents[moving1][moving1-x+y]) instanceof EmptySlotComponent)){
                    return false;
                }
            }
        }else{
            return false;
        }
        return true;
    }











    /**
     *
     *
     *
     *
     *
     *
     *
     * @param g
     */







    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//        g.drawImage(rookImage, 0, 0, getWidth() - 13, getHeight() - 20, this);
        g.drawImage(bishopImage, 0, 0, getWidth() , getHeight(), this);
        g.setColor(Color.BLACK);
        if (isSelected()) { // Highlights the model if selected.
            g.setColor(Color.RED);
            g.drawOval(0, 0, getWidth() , getHeight());
        }







}}
