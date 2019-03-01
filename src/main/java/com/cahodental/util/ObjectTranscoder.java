package com.cahodental.util;

/*
 * Created by renhongjiang on 2019/3/1.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2019/3/1 9:51
 */
public class ObjectTranscoder<E extends Serializable> extends AbstractSerializeTranscoder {

    @Override
    @SuppressWarnings("unchecked")
    protected byte[] serialize(Object object) {
        if (object == null) {
            throw new NullPointerException("Can't serialize null");
        }
        byte[] bytes;
        ObjectOutputStream os = null;
        ByteArrayOutputStream bos = null;
        try {
            bos = new ByteArrayOutputStream();
            os = new ObjectOutputStream(bos);
            os.writeObject(object);
            os.close();
            bos.close();
            bytes = bos.toByteArray();
        } catch (IOException e) {
            throw new IllegalArgumentException("Non-serializable object", e);
        } finally {
            close(os);
            close(bos);
        }
        return bytes;
    }

    @Override
    @SuppressWarnings("unchecked")
    protected E deserialize(byte[] bytes) {
        if (bytes == null) {
            throw new NullPointerException("Can't deserialize null");
        }
        E object = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream is = null;
        try {
            bis = new ByteArrayInputStream(bytes);
            is = new ObjectInputStream(bis);
            object = (E) is.readObject();
            is.close();
            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            close(is);
            close(bis);
        }
        return object;
    }
}