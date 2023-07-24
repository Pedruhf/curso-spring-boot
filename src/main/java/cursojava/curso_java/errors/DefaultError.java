package cursojava.curso_java.errors;

public class DefaultError {

  public DefaultError(Integer status, String message) {
    this.status = status;
    this.message = message;
  }

  private Integer status;
  
  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  private String message;
}
