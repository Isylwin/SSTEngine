/**
 * The MIT License
 * Copyright (c) 2014 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 **/

package com.sstengine.event.framework;

/**
 * A {@link Event} is an object with a specific type that is associated
 * to a specific {@link Handler}.
 *
 * @author Ilkka Seppälä
 * @author Oscar de Leeuw
 */
@FunctionalInterface
public interface Event {
    /**
     * Returns the message type as a Class object. In this example the message type is
     * used to handle events by their type.
     *
     * @return the message type as a Class.
     */
    Class<? extends Event> getType();
}
