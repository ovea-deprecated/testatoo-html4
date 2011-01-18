/**
 * Copyright (C) 2008 Ovea <dev@testatoo.org>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.testatoo.cartridge.html4.element;

import org.testatoo.cartridge.html4.HtmlEvaluator;
import org.testatoo.core.ComponentException;
import org.testatoo.core.component.Component;

import static org.testatoo.cartridge.html4.element.HtmlElementType.Frame;


/**
 * This class allows the testing of the "frame" element properties for html4.
 *
 * @author dev@testatoo.org
 * @see <a href="http://www.w3.org/TR/html401/present/frames.html#edef-FRAME"> frame specification </a>
 */


public final class Frame extends Component implements Coreattrs {

    private CoreAttributeSupport coreAttributeSupport;
    private AttributeSupport attributeSupport;

    /**
     * Class constructor specifying the evaluator to use and the id of the "frame" element we want to test.
     *
     * @param evaluator a UI Test engine specific html evaluator
     * @param id        the id (unique) of the "frame" element
     * @throws ComponentException if the given id does not correspond to a "frame" element
     */
    public Frame(HtmlEvaluator evaluator, String id) {
        super(evaluator, id);
        this.evaluator = evaluator;

        coreAttributeSupport = new CoreAttributeSupport(evaluator);
        attributeSupport = new AttributeSupport(evaluator);
        if (evaluator.htmlElementType(id) != Frame) {
            throw new ComponentException("The component with id=" + id + " is not a " + Frame + " but a " + evaluator.htmlElementType(id));
        }
    }

    /**
     * @see CoreAttributeSupport
     */
    public String classname() {
        return coreAttributeSupport.classname(this);
    }

    /**
     * @see CoreAttributeSupport
     */
    public String style() {
        return coreAttributeSupport.style(this);
    }

    /**
     * @see CoreAttributeSupport
     */
    public String title() {
        return coreAttributeSupport.title(this);
    }

    /**
     * To get the name attribute of the frame.
     * This name may be used as the target of subsequent links.
     *
     * @return the name of the "frame" element
     * @see <a href="http://www.w3.org/TR/html401/present/frames.html#adef-name-FRAME">W3C recommendation</a>
     */
    public String name() {
        return attributeSupport.name(this);
    }

    /**
     * To get the longdesc attribute of the frame.
     * Longdesc is a long description of the frame.
     *
     * @return the longdesc of the "frame" element
     * @see <a href="http://www.w3.org/TR/html401/present/frames.html#adef-longdesc-FRAME">W3C recommendation</a>
     */
    public String longdesc() {
        return attributeSupport.longdesc(this);
    }

    /**
     * To get the src attribute of the frame.
     * Src specifies the location of the initial contents to be contained in the frame.
     *
     * @return the src of the "frame" element
     * @see <a href="http://www.w3.org/TR/html401/present/frames.html#adef-src-FRAME">W3C recommendation</a>
     */
    public String src() {
        return attributeSupport.src(this);
    }

    /**
     * To get the frameborder attribute of the frame.
     * Possible values are 0 (no separator) or 1 (one separator).
     *
     * @return the frameborder of the "frame" element
     * @see <a href="http://www.w3.org/TR/html401/present/frames.html#adef-frameborder">W3C recommendation</a>
     */
    public int frameborder() {
        return attributeSupport.frameborder(this);
    }

    /**
     * To get the marginwidth attribute of the frame.
     * It is the space to be left between the frame's contents in its left and right margins.
     *
     * @return the marginwidth of the "frame" element
     * @see <a href="http://www.w3.org/TR/html401/present/frames.html#adef-marginwidth">W3C recommendation</a>
     */
    public int marginwidth() {
        return attributeSupport.marginwidth(this);
    }

    /**
     * To get the marginheight attribute of the frame.
     * It is the space to be left between the frame's contents in its top and bottom margins.
     *
     * @return the marginheight of the "frame" element
     * @see <a href="http://www.w3.org/TR/html401/present/frames.html#adef-marginheight">W3C recommendation</a>
     */
    public int marginheight() {
        return attributeSupport.marginheight(this);
    }

    /**
     * To get the noresize attribute of the frame.
     * it indicates if the frame window must not be resizable.
     *
     * @return the noresize of the "frame" element
     * @see <a href="http://www.w3.org/TR/html401/present/frames.html#adef-noresize">W3C recommendation</a>
     */
    public boolean noresize() {
        return attributeSupport.noresize(this);
    }

    /**
     * To get the scrolling attribute of the frame.
     * specifies scroll information for the frame window (auto, yes, no).
     *
     * @return the scrolling of the "frame" element
     * @see <a href="http://www.w3.org/TR/html401/present/frames.html#adef-scrolling">W3C recommendation</a>
     */
    public Scrolling scrolling() {
        return attributeSupport.scrolling(this);
    }

    // TODO : contains ??

    /**
     * To get the string describing the frame.
     *
     * @return string describing the frame
     */
    public String toString() {
        return super.toString() + ", title:" + title();
    }
}