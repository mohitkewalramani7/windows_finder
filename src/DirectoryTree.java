import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import java.io.File;

/**
 * An class to generate the Directory Tree that is shown for the user to generate
 * a tree. The tree is mapped to directories, and directories of that hierarchy
 * are created within the local filesystem where the user's viewing FileList is currently
 * located
 *
 * @author Mohit Kewalramani
 * @since 2017-07-22
 * @version 1.0
 */
public class DirectoryTree {

    private DefaultMutableTreeNode rootNode; // Instance of the DefaultMutableTreeNode
    private DefaultTreeModel treeModel;    // Instance of the DefaultTreeModel (Uses the root)
    public JTree tree; // Instance of the JTree

    /**
     * Constructs the instance of the DirectoryTree.
     * Initializes the JTree to construct a tree given the rootNode.
     */
    public DirectoryTree(){
        rootNode = new DefaultMutableTreeNode("Current Dir");
        treeModel = new DefaultTreeModel(rootNode);
        tree = new JTree(treeModel);
    }

    /**
     * Sets the properties of the JTree.
     *
     * @return JTree The JTree with all the properties set
     */
    public JTree setTreeProperties(){
        tree.setEditable(true);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);
        tree.setShowsRootHandles(true);
        return tree;
    }

    /**
     * Adds a leaf to the JTree with a given child name.
     *
     * @param child The name of the leaf to add
     * @return DefaultMutableTreeNode The child node added
     */
    public DefaultMutableTreeNode addObject(Object child) {
        DefaultMutableTreeNode parentNode;
        TreePath parentPath = tree.getSelectionPath();

        if (parentPath == null) {
            //There is no selection. Default to the root node.
            parentNode = rootNode;
        } else {
            parentNode = (DefaultMutableTreeNode)
                    (parentPath.getLastPathComponent());
        }

        return addObjectHelper(parentNode, child, true);
    }

    /**
     * A helper method to add a child to the JTree.
     *
     * @param parent Parent node to add the child to
     * @param child Child node to add
     * @param shouldBeVisible Whether or not the added node should be visible
     * @return DefaultMutableTreeNode The added childNode
     */
    private DefaultMutableTreeNode addObjectHelper(DefaultMutableTreeNode parent,
                                                  Object child,
                                                  boolean shouldBeVisible) {
        DefaultMutableTreeNode childNode =
                new DefaultMutableTreeNode(child);
        treeModel.insertNodeInto(childNode, parent,
                parent.getChildCount());

        //Make sure the user can see the lovely new node.
        if (shouldBeVisible) {
            tree.scrollPathToVisible(new TreePath(childNode.getPath()));
        }
        return childNode;
    }

    /**
     * Deletes the selected leaf/parent on the JTree.
     */
    public void deleteObject(){
        TreePath[] parentPaths = tree.getSelectionPaths();
        if (parentPaths == null){
            JOptionPane.showMessageDialog(null, "Please Select A Folder First");
        }
        else{
            for (TreePath path : parentPaths){
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) path.getLastPathComponent();
                treeModel.removeNodeFromParent(selectedNode);
            }
        }
    }

    /**
     * Method to traverse all leafs of the constructed JTree.
     *
     * @param dataPath The path in which to create the JTree structure directories
     */
    public void traverseChildNodes(String dataPath){
        traverseTree(rootNode, dataPath);
        JOptionPane.showMessageDialog(null, "Directories Created");
    }

    /**
     * Helper method to recursively traverse all leafs of the constructed JTree.
     *
     * @param root The root node of the JTree that is constructed
     * @param dataPath The data path in which to create the JTree structure directories
     */
    private void traverseTree(DefaultMutableTreeNode root, String dataPath) {
        try {
            new File(dataPath + "\\" + root.toString()).mkdir();
            for (int i = 0; i < root.getChildCount(); i++) {
                String newDirectory = dataPath + "\\" + root.toString();
                new File(newDirectory).mkdir();
                traverseTree((DefaultMutableTreeNode) root.getChildAt(i), newDirectory);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error in creating directories");
            System.out.println(e);
        }
    }

}
