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

import com.sstengine.Game;

/**
 * This interface can be implemented to handle different types of messages.
 * Every handler is responsible for a single of type message.
 *
 * @author Ilkka Seppälä
 * @author Oscar de Leeuw
 */
public interface Handler<E extends Event> {
    /**
     * The onEvent method should implement and handle behavior related to the event.
     * This can be as simple as calling another service to handle the event on publishing the event on
     * a queue to be consumed by other sub systems.
     * @param event the {@link Event} object to be handled.
     */
    void onEvent(E event, Game game);
}
