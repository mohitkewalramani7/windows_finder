import java.awt.*;

/**
 * The class that sets up the GridBagConstraints for the individual components added to the GUI
 *
 * @author Mohit Kewalramani
 * @since 2017-07-22
 * @version 1.0
 *
 */
public class GridBagConstraintsConfiguration {

    // GridBagConstraints instances of each component to be added to the GUI
    GridBagConstraints titleGridBagConstraints;
    GridBagConstraints filesListGridBagConstraints;
    GridBagConstraints directoryTreeGridBagConstraints;
    GridBagConstraints treeAddButtonConstraints;
    GridBagConstraints treeRemoveButtonConstraints;
    GridBagConstraints removeButtonGridBagConstraints;
    GridBagConstraints newFolderGridBagConstraints;
    GridBagConstraints refreshButtonGridBagConstraints;
    GridBagConstraints enterDirectoryGridBagConstraints;
    GridBagConstraints goBackDirectoryGridBagConstraints;
    GridBagConstraints confirmDirectoryButtonConstraints;

    // Constructor which initializes the instance of each GridBagConstraint
    public GridBagConstraintsConfiguration(){
        titleGridBagConstraints = new GridBagConstraints();
        filesListGridBagConstraints = new GridBagConstraints();
        directoryTreeGridBagConstraints = new GridBagConstraints();
        treeAddButtonConstraints = new GridBagConstraints();
        treeRemoveButtonConstraints = new GridBagConstraints();
        removeButtonGridBagConstraints = new GridBagConstraints();
        newFolderGridBagConstraints = new GridBagConstraints();
        refreshButtonGridBagConstraints = new GridBagConstraints();
        enterDirectoryGridBagConstraints = new GridBagConstraints();
        goBackDirectoryGridBagConstraints = new GridBagConstraints();
        confirmDirectoryButtonConstraints = new GridBagConstraints();
    }

    // All methods below respectively set the appropriate grid position, orientation, and, size within each cell.

    public GridBagConstraints setTitleConstraints(){
        titleGridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        titleGridBagConstraints.gridx = 0;
        titleGridBagConstraints.gridy = 0;
        titleGridBagConstraints.gridwidth = 4;
        titleGridBagConstraints.ipady = 50;
        return titleGridBagConstraints;
    }

    public GridBagConstraints setFilesListConstraints(){
        filesListGridBagConstraints.fill = GridBagConstraints.VERTICAL;
        filesListGridBagConstraints.gridx = 0;
        filesListGridBagConstraints.gridy = 1;
        filesListGridBagConstraints.weightx = 0;
        filesListGridBagConstraints.weighty = 1;
        filesListGridBagConstraints.gridwidth = 2;
        filesListGridBagConstraints.insets = new Insets(0,40,30,0);
        return filesListGridBagConstraints;
    }

    public GridBagConstraints setDirectoryTreeConstraints(){
        directoryTreeGridBagConstraints.fill = GridBagConstraints.VERTICAL;
        directoryTreeGridBagConstraints.gridx = 2;
        directoryTreeGridBagConstraints.gridy = 1;
        directoryTreeGridBagConstraints.weightx = 1;
        return directoryTreeGridBagConstraints;
    }

    public GridBagConstraints setTreeAddDirectoryButtonConstraints(){
        treeAddButtonConstraints.fill = GridBagConstraints.HORIZONTAL;
        treeAddButtonConstraints.gridx = 3;
        treeAddButtonConstraints.gridy = 2;
        treeAddButtonConstraints.weightx = 0.5;
        return treeAddButtonConstraints;
    }

    public GridBagConstraints setTreeRemoveDirectoryButtonConstraints(){
        treeRemoveButtonConstraints.fill = GridBagConstraints.HORIZONTAL;
        treeRemoveButtonConstraints.gridx = 3;
        treeRemoveButtonConstraints.gridy = 3;
        treeRemoveButtonConstraints.weightx = 0.5;
        return treeRemoveButtonConstraints;
    }

    public GridBagConstraints setEnterDirectoryConstraints(){
        enterDirectoryGridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        enterDirectoryGridBagConstraints.gridx = 0;
        enterDirectoryGridBagConstraints.gridy = 2;
        enterDirectoryGridBagConstraints.weightx = 0.2;
        return enterDirectoryGridBagConstraints;
    }

    public GridBagConstraints setRemoveButtonConstraints(){
        removeButtonGridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        removeButtonGridBagConstraints.gridx = 1;
        removeButtonGridBagConstraints.gridy = 2;
        removeButtonGridBagConstraints.weightx = 0.2;
        return removeButtonGridBagConstraints;
    }

    public GridBagConstraints setNewFolderConstraints(){
        newFolderGridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        newFolderGridBagConstraints.gridx = 1;
        newFolderGridBagConstraints.gridy = 3;
        newFolderGridBagConstraints.weightx = 0.2;
        return newFolderGridBagConstraints;
    }

    public GridBagConstraints setGoBackDirectoryConstraints(){
        goBackDirectoryGridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        goBackDirectoryGridBagConstraints.gridx = 0;
        goBackDirectoryGridBagConstraints.gridy = 3;
        goBackDirectoryGridBagConstraints.weightx = 0.2;
        return goBackDirectoryGridBagConstraints;
    }

    public GridBagConstraints setRefreshButtonConstraints(){
        refreshButtonGridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        refreshButtonGridBagConstraints.gridx = 0;
        refreshButtonGridBagConstraints.gridy = 4;
        refreshButtonGridBagConstraints.weightx = 0.2;
        return refreshButtonGridBagConstraints;
    }

    public GridBagConstraints setConfirmDirectoriesButtonConstraints(){
        confirmDirectoryButtonConstraints.fill = GridBagConstraints.HORIZONTAL;
        confirmDirectoryButtonConstraints.gridx = 3;
        confirmDirectoryButtonConstraints.gridy = 1;
        confirmDirectoryButtonConstraints.weightx = 0.2;
        return confirmDirectoryButtonConstraints;
    }
}
