package dao;

import models.Tree;

import java.util.List;

public interface TreeDao {
    //create
    void addTree(Tree tree);
    void userPlantTree(int userId, int treeId, String latitude, String longitude);

    //read
    Tree findTreeById(int treeId);
    List<Tree> getAllTrees();
    List<Tree> getTreesPlantedByUser(int userId);

    //update

    //delete

}