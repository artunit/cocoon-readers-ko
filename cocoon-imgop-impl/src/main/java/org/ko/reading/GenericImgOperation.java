/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/* 
slight modifications for ourontario newspaper application.
*/

package org.ko.reading.imgop;

import org.apache.avalon.framework.parameters.Parameters;
import org.apache.cocoon.ProcessingException;

public interface GenericImgOperation {

    String ROLE = ImgOperation.class.getName();

    void setPrefix( String prefix );

    void setup( Parameters params ) 
    throws ProcessingException;

    String getKey();
} 
