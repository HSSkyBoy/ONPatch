package org.lsposed.lspatch.service;

import android.os.Environment;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

import org.lsposed.lspd.models.Module;
import org.lsposed.lspd.service.ILSPApplicationService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FixedLocalApplicationService extends ILSPApplicationService.Stub {
    private List<Module> cachedModule;
    @Override
    public List<Module> getLegacyModulesList() throws RemoteException {
        return cachedModule;
    }

    @Override
    public List<Module> getModulesList() throws RemoteException {
        return new ArrayList<>();
    }

    @Override
    public String getPrefsPath(String packageName) throws RemoteException {
        return new File(Environment.getDataDirectory(), "data/" + packageName + "/shared_prefs/").getAbsolutePath();
    }

    @Override
    public ParcelFileDescriptor requestInjectedManagerBinder(List<IBinder> binder) throws RemoteException {
        return null;
    }
    @Override
    public IBinder asBinder() {
        return this;
    }
}
