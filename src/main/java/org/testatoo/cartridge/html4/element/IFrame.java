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
import org.testatoo.core.nature.Container;

import static org.testatoo.cartridge.html4.element.HtmlElementType.IFrame;

/**
 * This class allows the testing of the "iframe" element properties for html4.
 * Iframe allows authors to insert a frame within a block of text.
 *
 * @author dev@testatoo.org
 * @see <a href="http://www.w3.org/TR/html401/present/frames.html#edef-IFRAME"> iframe specification </a>
 */

public final class IFrame extends Component implements Coreattrs, Container {

    private CoreAttributeSupport coreAttributeSupport;
    private AttributeSupport attributeSupport;

    /**
     * Class constructor specifying the evaluator to use and the id of the "iframe" element we want to test.
     *
     * @param evaluator a UI Test engine specific html evaluator
     * @param id        the id (unique) of the "iframe" element
     * @throws ComponentException if the given id does not correspond to a "iframe" element
     */
    public IFrame(HtmlEvaluator evaluator, String id) {
        super(evaluator, id);
        this.evaluator = evaluator;

        coreAttributeSupport = new CoreAttributeSupport(evaluator);
        attributeSupport = new AttributeSupport(evaluator);
        if (evaluator.htmlElementType(id) != IFrame) {
            throw new ComponentException("The component with id=" + id + " is not a " + IFrame + " but a " + evaluator.htmlElementType(id));
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
     * To get the name attribute of the iframe.
     * This name may be used as the target of subsequent links.
     *
     * @return the name of the "iframe" element
     * @see <a href="http://www.w3.org/TR/html401/present/frames.html#adef-name-IFRAME">W3C recommendation</a>
     */
    public String name() {
        return attributeSupport.name(this);
    }

    /**
     * To get the longdesc attribute of the iframe.
     * Longdesc is a long description of the iframe.
     *
     * @return the longdesc of the "iframe" element
     * @see <a href="http://www.w3.org/TR/html401/present/frames.html#adef-longdesc-IFRAME">W3C recommendation</a>
     */
    public String longdesc() {
        return attributeSupport.longdesc(this);
    }

    /**
     * To get the src attribute of the iframe.
     * Src specifies the location of the initial contents to be contained in the iframe.
     *
     * @return the src of the "iframe" element
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-src">W3C recommendation</a>
     */
    public String src() {
        return attributeSupport.src(this);
    }

    /**
     * To get the frameborder attribute of the iframe.
     * Possible values are 0 (no separator) or 1 (one separator).
     *
     * @return the frameborder of the "frame" element
     * @see <a href="http://www.w3.org/TR/html401/present/frames.html#adef-frameborder">W3C recommendation</a>
     */
    public int frameborder() {
        return attributeSupport.frameborder(this);
    }

    /**
     * To get the marginwidth attribute of the iframe.
     * It is the space to be left between the iframe's contents in its left and right margins.
     *
     * @return the marginwidth of the "iframe" element
     * @see <a href="http://www.w3.org/TR/html401/present/frames.html#adef-marginwidth">W3C recommendation</a>
     */
    public int marginwidth() {
        return attributeSupport.marginwidth(this);
    }

    /**
     * To get the marginheight attribute of the iframe.
     * It is the space to be left between the iframe's contents in its top and bottom margins.
     *
     * @return the marginheight of the "iframe" element
     * @see <a href="http://www.w3.org/TR/html401/present/frames.html#adef-marginheight">W3C recommendation</a>
     */
    public int marginheight() {
        return attributeSupport.marginheight(this);
    }

    /**
     * To get the scrolling attribute of the iframe.
     * Specifies scroll information for the iframe window (auto, yes, no).
     *
     * @return the scrolling of the "iframe" element
     * @see <a href="http://www.w3.org/TR/html401/present/frames.html#adef-scrolling">W3C recommendation</a>
     */
    public Scrolling scrolling() {
        return attributeSupport.scrolling(this);
    }

    /**
     * To know if the iframe contains all the given components.
     *
     * @param components components we want to know if contained in the iframe
     * @return True if all the components is contained in the iframe
     */
    public Boolean contains(Component... components) {
        return evaluator.contains(this, components);
    }

    /**
     * To get the string describing the iframe.
     *
     * @return string describing the iframe
     */
    public String toString() {
        return super.toString() + ", title:" + title();
    }
}
