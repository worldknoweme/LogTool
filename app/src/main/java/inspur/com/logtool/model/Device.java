package inspur.com.logtool.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * *Author 王建林
 * *E-mail wangjianlin1989@163.com
 * *TIME 2017/10/26  15:03
 * *
 * *Description:
 */
@Entity
public class Device {

    
    @Id
    private String ID;

    private String TIME;
    private String DEVICE_NAME;
    private String ACTION;
    private String CODE;
    private String DESCRIPTION;
    @Generated(hash = 774557268)
    public Device(String ID, String TIME, String DEVICE_NAME, String ACTION,
            String CODE, String DESCRIPTION) {
        this.ID = ID;
        this.TIME = TIME;
        this.DEVICE_NAME = DEVICE_NAME;
        this.ACTION = ACTION;
        this.CODE = CODE;
        this.DESCRIPTION = DESCRIPTION;
    }
    @Generated(hash = 1469582394)
    public Device() {
    }
    public String getID() {
        return this.ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public String getTIME() {
        return this.TIME;
    }
    public void setTIME(String TIME) {
        this.TIME = TIME;
    }
    public String getDEVICE_NAME() {
        return this.DEVICE_NAME;
    }
    public void setDEVICE_NAME(String DEVICE_NAME) {
        this.DEVICE_NAME = DEVICE_NAME;
    }
    public String getACTION() {
        return this.ACTION;
    }
    public void setACTION(String ACTION) {
        this.ACTION = ACTION;
    }
    public String getCODE() {
        return this.CODE;
    }
    public void setCODE(String CODE) {
        this.CODE = CODE;
    }
    public String getDESCRIPTION() {
        return this.DESCRIPTION;
    }
    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }


}
