/*
 * Licensed to the Technische Universität Darmstadt under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The Technische Universität Darmstadt 
 * licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.
 *  
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.tudarmstadt.ukp.inception.diam.model.compact;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import de.tudarmstadt.ukp.inception.diam.model.Offsets;
import de.tudarmstadt.ukp.inception.rendering.vmodel.VID;
import de.tudarmstadt.ukp.inception.support.json.BeanAsArraySerializer;

@JsonSerialize(using = BeanAsArraySerializer.class)
@JsonPropertyOrder(value = { "vid", "offsets", "attributes" })
public class CompactSpan
    implements CompactAnnotation
{
    private VID vid;
    private List<Offsets> offsets = new ArrayList<>();
    private CompactSpanAttributes attributes = new CompactSpanAttributes();

    public CompactSpan()
    {
        // Nothing to do
    }

    public CompactSpan(VID aVid, Offsets aOffsets, String aLabelText, String aColor)
    {
        this(aVid, asList(aOffsets), aLabelText, aColor);
    }

    public CompactSpan(VID aVid, List<Offsets> aOffsets, String aLabelText, String aColor)
    {
        vid = aVid;
        offsets = aOffsets;
        attributes.setLabelText(aLabelText);
        attributes.setColor(aColor);
    }

    @Override
    public VID getVid()
    {
        return vid;
    }

    public void setVid(VID aVid)
    {
        vid = aVid;
    }

    public List<Offsets> getOffsets()
    {
        return offsets;
    }

    public void setOffsets(List<Offsets> aOffsets)
    {
        offsets = aOffsets;
    }

    public CompactSpanAttributes getAttributes()
    {
        return attributes;
    }

    public void setAttributes(CompactSpanAttributes aAttributes)
    {
        attributes = aAttributes;
    }
}
