package entity;

/**
 * 〈一句话功能简述〉<br>
 * 〈数据请求返回结果实体类〉
 *
 * @author rp
 * @create 2018/12/18
 */
public class Result {

    private boolean flag;//是否成功
    private Integer code;// 返回码
    private String message;//返回信息
    private Object data;// 返回数据

    public Result() {
    }

    public  static Result ok(){
        return new Result(true,StatusCode.OK,"成功");
    }

    public  static Result ok(String message){
        return new Result(true,StatusCode.OK,message);
    }

    public  static Result error(){
        return new Result(false,StatusCode.ERROR,"失败");
    }

    public  static Result error(String message){
        return new Result(false,StatusCode.ERROR,message);
    }

    public Result(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    public Result(boolean flag, Integer code, String message, Object data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}