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

import java.awt.geom.AffineTransform;
import java.awt.Graphics2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.WritableRaster;
import java.awt.image.BufferedImage;
import java.awt.RenderingHints;

import org.apache.avalon.framework.parameters.Parameters;

public class ScaleOperation
    implements ImgOperation {

    private String  prefix;
    private boolean enabled;
    private float   scale;

    public void setPrefix( String prefix ) {
        this.prefix = prefix;
    }

    public void setup( Parameters params ) {
        enabled = params.getParameterAsBoolean( prefix + "enabled", true);
        scale = params.getParameterAsFloat( prefix + "scale", 1.0f );
    }

    public BufferedImage apply( BufferedImage image ) {
        int newWidth = new Double(image.getWidth() * scale).intValue();
        int newHeight = new Double(image.getHeight() * scale).intValue();

        BufferedImage resized = new BufferedImage(newWidth, newHeight, image.getType());

        Graphics2D g = resized.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(image, 0, 0, newWidth, newHeight, 0, 0, image.getWidth(), image.getHeight(), null);
        g.dispose();

        return resized;
    }

    public String getKey() {
        return "scale:" 
               + ( enabled ? "enable" : "disable" )
               + ":" + scale
               + ":" + prefix;
    }
} 
