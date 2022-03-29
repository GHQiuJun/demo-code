package demo.customspringtag;

/**
 * @program: SpringXmlTag
 * @description: SpringXmlTag
 * @author: 60007949
 * @create: 2022-03-29 17:52
 **/
public class SpringXmlTag {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
