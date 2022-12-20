package com.keyin.utlilities;

import com.keyin.algorithms.AvlTree;
import com.keyin.algorithms.Node;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JsonConverter {

    private JSONObject convertNode(Node node){

        if(node == null){
            return null;
        } else {
            JSONObject object = new JSONObject();
            object.put("value", node.value);
            object.put("left", convertNode(node.left));
            object.put("right", convertNode(node.right));
            return object;
        }
    }

    private JSONObject convertTreeToJsonContent(Node root){
        JSONObject objectContent = new JSONObject();
        if(root == null){
            return null;
        }
        if(root.left == null){
            objectContent.put("left", null);
        } else {
            objectContent.put("left", convertNode(root.left));
        }
        if(root.right == null){
            objectContent.put("right", null);
        } else {
            objectContent.put("right", convertNode(root.right));
        }
        objectContent.put("value",root.value);
        return objectContent;
    }

    public JSONObject convertTreeToJsonObject(Node root){
        JSONObject objectContent = convertTreeToJsonContent(root);
        JSONObject object = new JSONObject();
        object.put("Root", objectContent);

        return object;
    }

    public static void toFile(String filePath, JSONObject object){

    }
}
