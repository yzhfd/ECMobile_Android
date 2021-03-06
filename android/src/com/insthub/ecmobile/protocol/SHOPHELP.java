
package com.insthub.ecmobile.protocol;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.external.activeandroid.Model;
import com.external.activeandroid.annotation.Column;
import com.external.activeandroid.annotation.Table;

@Table(name = "SHOPHELP")
public class SHOPHELP  extends Model
{

     public ArrayList<ARTICLE>   article = new ArrayList<ARTICLE>();

     @Column(name = "name")
     public String name;

 public static SHOPHELP fromJson(JSONObject jsonObject)  throws JSONException
 {
     if(null == jsonObject){
       return null;
      }

     SHOPHELP   localItem = new SHOPHELP();

     JSONArray subItemArray;

     subItemArray = jsonObject.optJSONArray("article");
     if(null != subItemArray)
      {
         for(int i = 0;i < subItemArray.length();i++)
          {
             JSONObject subItemObject = subItemArray.getJSONObject(i);
             ARTICLE subItem = ARTICLE.fromJson(subItemObject);
             localItem.article.add(subItem);
         }
     }


     localItem.name = jsonObject.optString("name");
     return localItem;
 }

 public JSONObject  toJson() throws JSONException 
 {
     JSONObject localItemObject = new JSONObject();
     JSONArray itemJSONArray = new JSONArray();

     for(int i =0; i< article.size(); i++)
     {
         ARTICLE itemData =article.get(i);
         JSONObject itemJSONObject = itemData.toJson();
         itemJSONArray.put(itemJSONObject);
     }
     localItemObject.put("article", itemJSONArray);
     localItemObject.put("name", name);
     return localItemObject;
 }

}
