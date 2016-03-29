package hit.po;

public class Menu {
    private Integer menuId;

    private String menuname;

    private String url;

    private Integer isfather;

    private Integer menuIdParent;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname == null ? null : menuname.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getIsfather() {
        return isfather;
    }

    public void setIsfather(Integer isfather) {
        this.isfather = isfather;
    }

    public Integer getMenuIdParent() {
        return menuIdParent;
    }

    public void setMenuIdParent(Integer menuIdParent) {
        this.menuIdParent = menuIdParent;
    }
}