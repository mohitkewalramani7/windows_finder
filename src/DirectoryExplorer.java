import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;

/**
 * A class that initializes the main GUI of the DirectoryExplorer
 *
 * @author Mohit Kewalramani
 * @since 2017-07-22
 * @version 1.0
 */
public class DirectoryExplorer {

    // The current directory path shown on the GUI ScrollPane
    private String DIRECTORY_PATH = "C:\\Users";

    private ArrayList<String> fileList; // The files in the current directory
    private JFrame mainFrame; // The main GUI window
    private ImplementGUIComponents implementGUIComponents; // Instance of class that implements the GUI components
    private JList guiFileList; // The List on the GUI showing the list of files

    /**
     * Entry point of programme.
     *
     * @param args The arguments given to the programme
     */
    public static void main(String[] args) {
        DirectoryExplorer directoryExplorer = new DirectoryExplorer();
        directoryExplorer.prepareGUI();
    }

    /**
     * Constructs the Directory Explorer object.
     * Initializes a new fileList, sets up the JFrame, and
     * initializes a class to implement the helper methods of core components
     * of the GUI.
     * The file list is populated on the current directory (C://Users).
     */
    public DirectoryExplorer(){
        fileList = new ArrayList<>();
        mainFrame = new JFrame("Windows Finder");
        implementGUIComponents  = new ImplementGUIComponents();
        populateFileList();
    }

    /**
     * Populates the file list on the GUI, by iterating all
     * files in the current directory we are viewing.
     */
    private void populateFileList(){
        fileList = new ArrayList<>();
        File a = new File(DIRECTORY_PATH);
        for (File f : a.listFiles()){
            fileList.add(f.getName());
        }
    }

    /**
     * Prepares the core components and size of the GUI.
     * Sets the visibility of the mainFrame to be true.
     */
    private void prepareGUI(){
        mainFrame.setSize(1150,600);
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        mainFrame.setLayout(new GridBagLayout());

        implementGUIComponents.setGUITitle(mainFrame);
        guiFileList = implementGUIComponents.setGUIFileList(mainFrame, fileList);

        JButton deleteButton = implementGUIComponents.setDeleteButton(mainFrame);
        setDeleteButtonAction(deleteButton);

        JButton newFolderButton = implementGUIComponents.setNewFolderButton(mainFrame);
        setNewFolderButtonAction(newFolderButton);

        DirectoryTree addDirsTree = implementGUIComponents.setDirectoryTree(mainFrame);

        JButton treeAddDirectoryButton = implementGUIComponents.setTreeAddDirectoryButton(mainFrame);
        setTreeAddDirectoryButtonAction(addDirsTree, treeAddDirectoryButton);

        JButton treeRemoveDirectoryButton = implementGUIComponents.setTreeRemoveDirectoryButton(mainFrame);
        setTreeRemoveDirectoryButtonAction(addDirsTree, treeRemoveDirectoryButton);

        JButton refreshButton = implementGUIComponents.setRefreshButton(mainFrame);
        setRefreshButtonAction(refreshButton);

        JButton enterButton = implementGUIComponents.setEnterDirectoryButton(mainFrame);
        setEnterDirectoryButtonAction(enterButton);

        JButton backButton = implementGUIComponents.setBackButton(mainFrame);
        setBackButtonAction(backButton);

        JButton confirmDirectoryCreation = implementGUIComponents.setConfirmDirectoriesButton(mainFrame);
        setConfirmDirectoryCreationButtonAction(addDirsTree, confirmDirectoryCreation);

        mainFrame.setVisible(true);
    }

    /**
     * Sets the action of the Delete Button to delete the file.
     *
     * @param deleteButton The delete button on the GUI
     */
    private void setDeleteButtonAction(JButton deleteButton){
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    deleteFile(guiFileList.getSelectedValue().toString());
                } catch (Exception e1) {
                    deleteFile(null);
                }
                populateFileList();
                guiFileList.setListData(fileList.toArray());
            }
        });
    }

    /**
     * Sets the action of the New Folder Button.
     *
     * @param newFolderButton New Folder Button on GUI
     */
    private void setNewFolderButtonAction(JButton newFolderButton){
        newFolderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewDirectory();
                populateFileList();
                guiFileList.setListData(fileList.toArray());
            }
        });
    }

    /**
     * Adds a leaf to the JTree based on the selected parent node
     * selected.
     *
     * @param directoryTree The instance of the directory tree shown on the GUI
     * @param addDirectoryButton The tree add directory button on the GUI
     */
    private void setTreeAddDirectoryButtonAction(final DirectoryTree directoryTree, JButton addDirectoryButton){
        addDirectoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                directoryTree.addObject("New Folder");
            }
        });
    }

    /**
     * Removes the selected leaf/parent from the JTree.
     *
     * @param directoryTree The instance of the directory tree shown on the GUI
     * @param deleteDirectoryButton The tree remove directory button on the GUI
     */
    private void setTreeRemoveDirectoryButtonAction(final DirectoryTree directoryTree, JButton deleteDirectoryButton){
        deleteDirectoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                directoryTree.deleteObject();
            }
        });
    }

    /**
     * Refreshes the listView on the GUI that shows the files present in the
     * currently present directory.
     *
     * @param refreshButton The refresh button on the GUI
     */
    private void setRefreshButtonAction(JButton refreshButton){
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                populateFileList();
                guiFileList.setListData(fileList.toArray());
            }
        });
    }

    /**
     * Enters (cd dir) the selected directory on the GUI.
     *
     * @param enterDirectoryButton The enter directory button on the GUI
     */
    private void setEnterDirectoryButtonAction(JButton enterDirectoryButton){
        enterDirectoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    enterDirectory(guiFileList.getSelectedValue().toString());
                } catch (Exception e1) {
                    enterDirectory(null);
                }
                populateFileList();
                guiFileList.setListData(fileList.toArray());
            }
        });
    }

    /**
     * Goes up one level from the current directory in which we are present.
     *
     * @param backButton The back button on the GUI
     */
    private void setBackButtonAction(JButton backButton){
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File dir = new File(DIRECTORY_PATH);
                if (dir.getParent() != null){
                    DIRECTORY_PATH = dir.getParent();
                }
                populateFileList();
                guiFileList.setListData(fileList.toArray());
            }
        });
    }

    /**
     * Creates the directories as constructed on the JTree. The directories are created
     * in the current directory in which the user is present.
     *
     * @param directoryTree The instance of the directory tree shown on the GUI
     * @param confirmDirectories The Confirm Directories button on the GUI
     */
    private void setConfirmDirectoryCreationButtonAction(final DirectoryTree directoryTree, JButton confirmDirectories){
        confirmDirectories.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                directoryTree.traverseChildNodes(DIRECTORY_PATH);
            }
        });
    }

    /**
     * A helper method to perform the selected directory or file deletion from the fileList
     * displayed on the GUI.
     *
     * @param fileName The name of the file or directory selected
     */
    private void deleteFile(String fileName){
        File targetFile = new File(DIRECTORY_PATH + "\\" + fileName);
        if (fileName == null){
            JOptionPane.showMessageDialog(null, "Please Select A File or Directory First");
            return;
        }
        else if (targetFile.isFile()){
            JOptionPane.showMessageDialog(null, "Deleting file");
            targetFile.delete();
        }
        else if (targetFile.isDirectory()){
            JOptionPane.showMessageDialog(null, "Deleting directory");
            if (targetFile.listFiles().length > 0){
                deleteDirectoryRecursively(targetFile);
            }
            else{
                targetFile.delete();
            }
        }
    }

    /**
     * A helper method to recursively delete non-empty directories.
     *
     * @param file The name of the non-empty directory selected
     */
    private void deleteDirectoryRecursively(File file){
        if (file.isDirectory()){
            for (File f : file.listFiles()){
                deleteDirectoryRecursively(f);
            }
            file.delete();
        }
        else{
            file.delete();
        }
    }

    /**
     * A helper method to create a new directory in the currently present directory
     */
    private void createNewDirectory(){
        new File(DIRECTORY_PATH + "\\New Folder").mkdir();
    }

    /**
     * A helper method to enter the selected directory on the listView.
     *
     * @param selectedDir The name of the selected directory to enter
     */
    private void enterDirectory(String selectedDir){
        if (selectedDir == null){
            JOptionPane.showMessageDialog(null, "Please Select A File or Directory First");
            return;
        }
        File enterDir = new File(DIRECTORY_PATH + "\\" + selectedDir);
        if (enterDir.listFiles() == null){
            JOptionPane.showMessageDialog(null, "This Directory Does Not Exist");
            return;
        }
        if (enterDir.isDirectory()){
            DIRECTORY_PATH = DIRECTORY_PATH + "\\" + selectedDir;
        }
    }

}
