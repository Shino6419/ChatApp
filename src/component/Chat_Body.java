
package component;

import java.awt.Adjustable;
import java.awt.Color;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JScrollBar;
import net.miginfocom.swing.MigLayout;
import swing.ScrollBar;

public class Chat_Body extends javax.swing.JPanel {

 
    public Chat_Body() {
        initComponents();
        init();
        addItemLeft("lmao", "Dave");
        
        addDate("06/09/2004");
        addItemRight("gay", new ImageIcon(getClass().getResource("/icon/test/test.png")));
        addItemLeft("", "Dave", new ImageIcon(getClass().getResource("/icon/test/test.png")));
        String img[] ={"LNN-A$ks1BD-F}iv9hp0EQxUw_N2"};
        addItemLeft("", "Dave", img);
        addItemFile("test", "Dave","test.txt", " 5mb");
    }
    private void init() {
        body.setLayout(new MigLayout("fillx", "", "5[]5"));
        sp.setVerticalScrollBar(new ScrollBar());
        sp.getVerticalScrollBar().setBackground(Color.WHITE);
    } 
    
    
    public void addItemLeft(String text, String user, Icon... image) {
        Chat_Left_With_Profile item = new Chat_Left_With_Profile();
        item.setText(text);
        if (image != null && image.length > 0){
        item.setImage(image);
        }
        item.setTime();
        item.setUserProfile(user);
        body.add(item, "wrap, w 100::80%");
        //  ::80% set max with 80%
        body.repaint();
        body.revalidate();
    }
    public void addItemLeft(String text, String user, String[] image) {
        Chat_Left_With_Profile item = new Chat_Left_With_Profile();
        item.setText(text);
        item.setImage(image);
        item.setTime();
        item.setUserProfile(user);
        body.add(item, "wrap, w 100::80%");
        //  ::80% set max with 80%
        body.repaint();
        body.revalidate();
    }
    public void addItemFile(String text, String user, String fileName, String fileSize) {
        Chat_Left_With_Profile item = new Chat_Left_With_Profile();
        item.setText(text);
        item.setFile(fileName, fileSize);
        item.setTime();
        item.setUserProfile(user);
        body.add(item, "wrap, w 100::80%");
        //  ::80% set max with 80%
        body.repaint();
        body.revalidate();
    }

    public void addItemRight(String text, Icon... image) {
        Chat_Right item = new Chat_Right();
        item.setText(text);
        item.setImage(image);
        item.setTime();
        body.add(item, "wrap, al right, w 100::80%");
        //  ::80% set max with 80%
        body.repaint();
        body.revalidate();
        scrollToBottom();
    }
    public void addItemFileRight(String text, String fileName, String fileSize) {
        Chat_Right item = new Chat_Right();
        item.setText(text);
        item.setFile(fileName, fileSize);
        item.setTime();
        body.add(item, "wrap, al right, w 100::80%");
        //  ::80% set max with 80%
        body.repaint();
        body.revalidate();
    }
    
    
    public void addDate(String date) {
        Chat_Date item = new Chat_Date();
        item.setDate(date);
        body.add(item, "wrap, al center");
        body.repaint();
        body.revalidate();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        sp = new javax.swing.JScrollPane();
        body = new javax.swing.JPanel();

        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        body.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 684, Short.MAX_VALUE)
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 359, Short.MAX_VALUE)
        );

        sp.setViewportView(body);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void scrollToBottom() {
        JScrollBar verticalBar = sp.getVerticalScrollBar();
        AdjustmentListener downScroller = new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                Adjustable adjustable = e.getAdjustable();
                adjustable.setValue(adjustable.getMaximum());
                verticalBar.removeAdjustmentListener(this);
            }
        };
        verticalBar.addAdjustmentListener(downScroller);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
