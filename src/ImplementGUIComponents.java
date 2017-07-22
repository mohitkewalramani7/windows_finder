import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * The class that sets the properties of the individual components on the GUI
 *
 * @author Mohit Kewalramani
 * @since 2017-07-22
 * @version 1.0
 */
public class ImplementGUIComponents {

    // The instance of the GridBadConstraintsConfiguration that sets the layout properties of the GUI components
    private GridBagConstraintsConfiguration gridBagConstraintsConfiguration;

    /**
     * The constructor of the class that creates a new instance of the GridBagConstraintsConfiguration class.
     */
    public ImplementGUIComponents(){
        gridBagConstraintsConfiguration = new GridBagConstraintsConfiguration();
    }

    /**
     * Sets the properties of the GUI Title.
     *
     * @param mainFrame The mainframe GUI
     */
    public void setGUITitle(JFrame mainFrame){
        JLabel title = new JLabel("Windows Finder");
        title.setFont(new Font("Arial", Font.PLAIN, 45));
        title.setHorizontalAlignment(JLabel.CENTER);
        mainFrame.add(title, gridBagConstraintsConfiguration.setTitleConstraints());
    }

    /**
     * Sets the properties of the GUI File List, and adds the JScrollPane to the GUI. The method returns
     * the JList so it can be updated in the future.
     *
     * @param mainFrame The mainframe GUI
     * @param fileList The list of files in the current directory, to be added to the File List
     * @return JList the constructed JList to be updated as the user changes directories
     */
    public JList setGUIFileList(JFrame mainFrame, ArrayList<String> fileList){
        final JList guiFileList = new JList(fileList.toArray());
        guiFileList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        JScrollPane listScroller = new JScrollPane(guiFileList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        listScroller.setPreferredSize(new Dimension(250, 80));
        mainFrame.add(listScroller, gridBagConstraintsConfiguration.setFilesListConstraints());
        return guiFileList;
    }

    /**
     * Sets the properties of the JTree that is constructed by the user. The method adds the JScrollPane
     * to the mainFrame, however the method returns the JTree so it can be recursively iterated and the
     * directories can be created.
     *
     * @param mainframe The mainframe GUI
     * @return JTree The constructed JTree by the user
     */
    public DirectoryTree setDirectoryTree(JFrame mainframe){
        DirectoryTree directoryTree = new DirectoryTree();
        JTree constructedTree = directoryTree.setTreeProperties();
        JScrollPane treeScroller = new JScrollPane(constructedTree, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        treeScroller.setPreferredSize(new Dimension(250, 80));
        mainframe.add(treeScroller, gridBagConstraintsConfiguration.setDirectoryTreeConstraints());
        return directoryTree;
    }

    /**
     * Adds the delete button to the GUI.
     *
     * @param mainFrame The mainframe GUI
     * @return JButton the deleteButton added to the GUI
     */
    public JButton setDeleteButton(JFrame mainFrame){
        JButton deleteButton = new JButton("Remove");
        mainFrame.add(deleteButton, gridBagConstraintsConfiguration.setRemoveButtonConstraints());
        return deleteButton;
    }

    /**
     * Adds a New Folder button to the GUI.
     *
     * @param mainFrame The mainframe GUI
     * @return JButton The New folder button added to the GUI
     */
    public JButton setNewFolderButton(JFrame mainFrame){
        JButton newFolderButton = new JButton("New Folder");
        mainFrame.add(newFolderButton, gridBagConstraintsConfiguration.setNewFolderConstraints());
        return newFolderButton;
    }

    /**
     * Adds an Add Directory Button to add directories to the JTree displayed for directory creation.
     *
     * @param mainFrame The mainframe GUI
     * @return JButton The Add Directory button for the JTree added to the GUI
     */
    public JButton setTreeAddDirectoryButton(JFrame mainFrame){
        JButton addDirectoryTreeButton = new JButton("Add Directory");
        mainFrame.add(addDirectoryTreeButton, gridBagConstraintsConfiguration.setTreeAddDirectoryButtonConstraints());
        return addDirectoryTreeButton;
    }

    /**
     * Adds a Remove Directory Button to remove a directory/parent from the JTree.
     *
     * @param mainFrame The mainframe GUI
     * @return JButton The Remove Directory button for the JTree added to the GUI
     */
    public JButton setTreeRemoveDirectoryButton(JFrame mainFrame){
        JButton removeDirectoryTreeButton = new JButton("Remove Directory");
        mainFrame.add(removeDirectoryTreeButton, gridBagConstraintsConfiguration.setTreeRemoveDirectoryButtonConstraints());
        return removeDirectoryTreeButton;
    }

    /**
     * Adds a refresh button to refresh the contents of the ListView displaying contents of the current directory.
     *
     * @param mainFrame The mainframe GUI
     * @return JButton The Refresh button for the ListView added to the GUI
     */
    public JButton setRefreshButton(JFrame mainFrame){
        JButton refreshListView = new JButton("Refresh");
        mainFrame.add(refreshListView, gridBagConstraintsConfiguration.setRefreshButtonConstraints());
        return refreshListView;
    }

    /**
     * Adds an enter directory button to enter a selected directory on the listView GUI.
     *
     * @param mainFrame The mainframe GUI
     * @return JButton The enter directory button added to the GUI
     */
    public JButton setEnterDirectoryButton(JFrame mainFrame){
        JButton enterDirectoryButton = new JButton("Enter Directory");
        mainFrame.add(enterDirectoryButton, gridBagConstraintsConfiguration.setEnterDirectoryConstraints());
        return enterDirectoryButton;
    }

    /**
     * Adds a go back button to go one level up from the current directory on the listView GUI.
     *
     * @param mainFrame The mainframe GUI
     * @return JButton The back button added to the GUI
     */
    public JButton setBackButton(JFrame mainFrame){
        JButton goBackDirectoryButton = new JButton("Back");
        mainFrame.add(goBackDirectoryButton, gridBagConstraintsConfiguration.setGoBackDirectoryConstraints());
        return goBackDirectoryButton;
    }

    /**
     * Adds a confirm directories button to the GUI, which proceeds to create the directories in
     * the currently located directory on the ListView based on the hierarchy constructed in the JTree.
     *
     * @param mainFrame The mainframe GUI
     * @return JButton The confirm directories button added to the GUI
     */
    public JButton setConfirmDirectoriesButton(JFrame mainFrame){
        JButton confirmDirectoriesButton = new JButton("Confirm Directory Creations");
        mainFrame.add(confirmDirectoriesButton, gridBagConstraintsConfiguration.setConfirmDirectoriesButtonConstraints());
        return confirmDirectoriesButton;
    }


}
