package travel_reminder;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.io.*;


public interface CNT_iGPS extends Remote{
  public boolean isGpsWeak() throws RemoteException;
}
