package entity;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈分页数据返回结果实体类〉
 *
 * @author rp
 * @create 2018/12/18
 */
public class PageResult<T> {

    private Long total;
    private List<T> rows;

    public PageResult() {
    }

    public PageResult(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}