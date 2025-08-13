import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class ToDoApp {

	 private JFrame frame;
	    private JTextField taskField;
	    private DefaultListModel<String> taskListModel;
	    private JList<String> taskList;

	    public ToDoApp() {
	        frame = new JFrame("To-Do List App");
	        frame.setSize(400, 400);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setLayout(new BorderLayout());

	        // Top Panel for input
	        JPanel inputPanel = new JPanel();
	        taskField = new JTextField(20);
	        JButton addButton = new JButton("Add Task");
	        inputPanel.add(taskField);
	        inputPanel.add(addButton);

	        // Center panel for task list
	        taskListModel = new DefaultListModel<>();
	        taskList = new JList<>(taskListModel);
	        JScrollPane scrollPane = new JScrollPane(taskList);

	        // Bottom panel for delete button
	        JPanel buttonPanel = new JPanel();
	        JButton deleteButton = new JButton("Delete Task");
	        buttonPanel.add(deleteButton);

	        // Add panels to frame
	        frame.add(inputPanel, BorderLayout.NORTH);
	        frame.add(scrollPane, BorderLayout.CENTER);
	        frame.add(buttonPanel, BorderLayout.SOUTH);

	        // Button Actions
	        addButton.addActionListener(e -> {
	            String task = taskField.getText().trim();
	            if (!task.isEmpty()) {
	                taskListModel.addElement(task);
	                taskField.setText("");
	            }
	        });

	        deleteButton.addActionListener(e -> {
	            int selectedIndex = taskList.getSelectedIndex();
	            if (selectedIndex != -1) {
	                taskListModel.remove(selectedIndex);
	            }
	        });

	        frame.setVisible(true);
	    }
	public static void main(String[] args) {
		
		 new ToDoApp();
	}

	
	
	
}
