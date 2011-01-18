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

import static org.testatoo.cartridge.html4.element.HtmlElementType.Img;

/**
 * This class allows the testing of the "img" element properties for html4.
 *
 * @author dev@testatoo.org
 * @see <a href="http://www.w3.org/TR/html401/struct/objects.html#edef-IMG"> "img" specification </a>
 */

public final class Img extends org.testatoo.core.component.Image implements Coreattrs, I18n {

    private CoreAttributeSupport coreAttributeSupport;
    private I18nAttributeSupport i18nAttributeSupport;
    private AttributeSupport attributeSupport;

    /**
     * Class constructor specifying the evaluator to use and the id of the "img" element we want to test.
     *
     * @param evaluator a UI Test engine specific html evaluator
     * @param id        the id (unique) of the "img" element
     */

    public Img(HtmlEvaluator evaluator, String id) {
        super(evaluator, id);
        this.evaluator = evaluator;

        coreAttributeSupport = new CoreAttributeSupport(evaluator);
        i18nAttributeSupport = new I18nAttributeSupport(evaluator);
        attributeSupport = new AttributeSupport(evaluator);
        if (evaluator.htmlElementType(id) != Img) {
            throw new ComponentException("The component with id=" + id + " is not a " + Img + " but a " + evaluator.htmlElementType(id));
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
     * @see I18nAttributeSupport
     */
    public String language() {
        return i18nAttributeSupport.language(this);
    }

    /**
     * @see I18nAttributeSupport
     */
    public Direction direction() {
        return i18nAttributeSupport.direction(this);
    }

    /**
     * To get the name attribute of the image.
     * This name may be used as the target of subsequent links.
     *
     * @return the name of the image
     * @see <a href="http://www.w3.org/TR/html401/struct/objects.html#adef-name-IMG">W3C recommendation</a>
     */
    public String name() {
        return attributeSupport.name(this);
    }

    /**
     * To get the alt attribute of the image.
     * Alt can be used when type is set to image to specify the alternative text of the image, for user agents that cannot display images.
     *
     * @return the alt of the image
     * @see <a href="http://www.w3.org/TR/html401/struct/objects.html#adef-alt">W3C recommendation</a>
     */
    public String alt() {
        return attributeSupport.alt(this);
    }

    /**
     * To get the longdesc attribute of the image.
     * Longdesc is a long description of the image.
     *
     * @return the longdesc of the image
     * @see <a href="http://www.w3.org/TR/html401/struct/objects.html#adef-longdesc-IMG">W3C recommendation</a>
     */
    public String longdesc() {
        return attributeSupport.longdesc(this);
    }

    /**
     * To get the usemap attribute of the image.
     * This attribute associates an image map (defined by a "map" element) to the image.
     *
     * @return the longdesc of the image
     * @see <a href="http://www.w3.org/TR/html401/struct/objects.html#adef-usemap">W3C recommendation</a>
     */
    public String usemap() {
        return attributeSupport.usemap(this);
    }

    /**
     * To get the height of the image.
     *
     * @return the height of the image
     * @see <a href="http://www.w3.org/TR/html401/struct/objects.html#adef-height-IMG">W3C recommendation</a>
     */
    public String height() {
        return attributeSupport.height(this);
    }

    /**
     * To get the width of the image.
     *
     * @return the width of the image
     * @see <a href="http://www.w3.org/TR/html401/struct/objects.html#adef-width-IMG">W3C recommendation</a>
     */
    public String width() {
        return attributeSupport.width(this);
    }
}
