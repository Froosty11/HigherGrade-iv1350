package main.integration;

public class DatabaseNotFoundException extends Exception{

    public DatabaseNotFoundException(String messageForUser, Exception excep){
        super(messageForUser,excep);
    }

    public String getAdminMessage(){
        StringBuilder strBu = new StringBuilder();
        strBu.append("Database Exception -  " + java.time.LocalDateTime.now()+ "\n");
        strBu.append(this.getMessage() + "\n");
        strBu.append(this.getStackTrace().toString());
        strBu.append("\nEnd of Log \n\n");
        return strBu.toString();
    }
}
