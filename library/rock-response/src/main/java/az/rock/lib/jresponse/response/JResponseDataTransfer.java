package az.rock.lib.jresponse.response;

import az.rock.lib.jresponse.JDataTransfer;
import az.rock.lib.jresponse.JHeader;


public class JResponseDataTransfer<D> extends JDataTransfer<D> {

    private Boolean success;
    private String message;

    public JResponseDataTransfer(D data, Boolean success, String message) {
        super(data);
        this.success = success;
        this.message = message;
    }

    public JResponseDataTransfer(JHeader header, D data, Boolean success, String message) {
        super(header, data);
        this.success = success;
        this.message = message;
    }

    public JResponseDataTransfer(D data, Boolean success) {
        super(data);
        this.success = success;
        this.message = null;
    }

    public JResponseDataTransfer(JHeader header, D data, Boolean success) {
        super(header, data);
        this.success = success;
        this.message = null;
    }

    public JResponseDataTransfer() {

    }

    public Boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }


    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
