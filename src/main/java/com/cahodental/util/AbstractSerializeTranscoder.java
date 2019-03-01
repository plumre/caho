package com.cahodental.util;

/*
 * Created by renhongjiang on 2019/3/1.
 */

import org.apache.log4j.Logger;

import java.io.Closeable;
import java.io.IOException;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2019/3/1 9:42
 */
public abstract class AbstractSerializeTranscoder {

    private static final Logger logger = Logger.getLogger(AbstractSerializeTranscoder.class);

    protected abstract byte[] serialize(Object object);

    protected abstract Object deserialize(byte[] bytes);

    protected void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                logger.info("Unable to close " + closeable, e);
            }
        }

    }

}