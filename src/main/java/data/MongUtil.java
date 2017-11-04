package data;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zuce wei on 2017/11/2.
 */
public class MongUtil {

    public static List<EdgeModel> readEdge(){
        List<EdgeModel> edgeList=new ArrayList();

        MongoClient m =null;
        try {
            int timeout = 30000;
            MongoClientOptions ops = MongoClientOptions.builder().maxConnectionLifeTime(timeout).build();
            ServerAddress s = new ServerAddress("192.168.1.102 ",27017);
            m = new MongoClient(s,ops);
        }catch(Exception e) {
            e.printStackTrace();
        }

        MongoDatabase db = m.getDatabase("test");
        MongoCollection<Document> collection = db.getCollection("graph");
        BasicDBObject filter_dbobject = new BasicDBObject();
        for (Document x: collection.find(filter_dbobject).limit(100).sort(new BasicDBObject("count",-1))) {
            EdgeModel edge=new EdgeModel();
            edge.setFrom(x.getString("from"));
            edge.setTo(x.getString("to"));
            edge.setCount(x.getInteger("count"));
            edgeList.add(edge);
        }

        return edgeList;
    }
}
