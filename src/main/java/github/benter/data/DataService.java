package github.benter.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataService {

  private static DataService instance = new DataService();
  private String resourcePath = "";

  private DataService(){}

  public static DataService getInstance(){
    return instance;
  }
  public void init(String resourcePath){
    this.resourcePath = resourcePath;
  }


  public <T extends Class>T read(String path,Class<T> type) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.readValue(new File(resourcePath+path), type);
  }

  public void write(String path, Object object) throws IOException {
    System.out.println("data path: " +resourcePath);
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.writeValue(new File(resourcePath+path+".json"), object);
  }
}
