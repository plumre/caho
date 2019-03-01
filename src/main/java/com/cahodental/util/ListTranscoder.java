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
public class ListTranscoder<E extends Serializable> extends AbstractSerializeTranscoder {

    @Override
    @SuppressWarnings("unchecked")
    protected byte[] serialize(Object object) {
        if (object == null) {
            throw new NullPointerException("Can't serialize null");
        }
        List<E> list = (List<E>) object;
        byte[] bytes;
        ObjectOutputStream os = null;
        ByteArrayOutputStream bos = null;
        try {
            bos = new ByteArrayOutputStream();
            os = new ObjectOutputStream(bos);
            for (E e : list) {
                os.writeObject(e);
            }
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
    protected List<E> deserialize(byte[] bytes) {
        if (bytes == null) {
            throw new NullPointerException("Can't deserialize null");
        }
        List<E> list = new ArrayList<>();
        ByteArrayInputStream bis = null;
        ObjectInputStream is = null;
        try {
            bis = new ByteArrayInputStream(bytes);
            is = new ObjectInputStream(bis);
            while (bis.available() > 0) {
                E e = (E) is.readObject();
                if (e == null) {
                    continue;
                }
                list.add(e);
            }
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
        return list;
    }
}