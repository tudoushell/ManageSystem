package entity;

public class Menu {
    private int id;
    private String menuName;
    private  String hrefUrl;
    private String parentId;
    private String createTime;

    public Menu() {
        super();
    }

    public Menu(int id, String menuName, String hrefUrl, String parentId, String createTime) {
        this.id = id;
        this.menuName = menuName;
        this.hrefUrl = hrefUrl;
        this.parentId = parentId;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getHrefUrl() {
        return hrefUrl;
    }

    public void setHrefUrl(String hrefUrl) {
        this.hrefUrl = hrefUrl;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", menuName='" + menuName + '\'' +
                ", hrefUrl='" + hrefUrl + '\'' +
                ", parentId='" + parentId + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
