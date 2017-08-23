package com.example.yvtc.yvtc081704.data;

import android.content.Context;

/**
 * Created by yvtc on 2017/8/22.
 */

public class StudentDAOFactory {
    public static StudentDAO newInstance(Context context, DAOType t)
    {
        switch (t)
        {
            case DAO_Memory:
                return new StudentDAOMemoryImpl();
            case DAO_FILE:
                return  new StudentDAOFileImpl(context);
            case DAO_DB:
                return new StudentDAODBImpl(context);
        }
        return null;
    }
}
