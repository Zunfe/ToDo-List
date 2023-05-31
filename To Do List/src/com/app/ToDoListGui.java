package com.app;

import java.awt.event.*;
import javax.swing.*;

public class ToDoListGui extends JFrame implements ActionListener {

    private JPanel taskPanel, taskComponetPanel;

    public ToDoListGui() {
        super("To Do List App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(CommonConstants.GUI_SIZE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        addGuiComponet();

    }

    private void addGuiComponet() {

        JLabel bannerLabel = new JLabel("To Do List ");

        bannerLabel.setBounds(
                (CommonConstants.GUI_SIZE.width - bannerLabel.getPreferredSize().width) / 2,
                15,
                CommonConstants.BANNER_SIZE.width,
                CommonConstants.BANNER_SIZE.height
        );

        taskPanel = new JPanel();

        taskComponetPanel = new JPanel();
        taskComponetPanel.setLayout(new BoxLayout(taskComponetPanel, BoxLayout.Y_AXIS));
        taskPanel.add(taskComponetPanel);

        //scroling
        JScrollPane scrolPane = new JScrollPane(taskPanel);
        scrolPane.setBounds(8, 70, CommonConstants.TASKPANEL_SIZE.width, CommonConstants.TASKPANEL_SIZE.height);
        scrolPane.setMaximumSize(CommonConstants.TASKPANEL_SIZE);
        scrolPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrolPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        //add task buttom 
        JButton addTaskButtom = new JButton("Add Task");
        addTaskButtom.setBounds(-5, CommonConstants.GUI_SIZE.height - 88,
                CommonConstants.ADD_TASK_BUTTOM_SIZE.width, CommonConstants.ADD_TASK_BUTTOM_SIZE.height);
        addTaskButtom.addActionListener(this);

        this.getContentPane().add(bannerLabel);
        this.getContentPane().add(scrolPane);
        this.getContentPane().add(addTaskButtom);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equalsIgnoreCase("Add Task")) {
            TaskComponent taskComponent;
            taskComponent = new TaskComponent(taskComponetPanel);
            taskComponetPanel.add(taskComponent);
            
            taskComponent.getTaskField().requestFocus();
            repaint();
            revalidate();
            
        }
    }

}
