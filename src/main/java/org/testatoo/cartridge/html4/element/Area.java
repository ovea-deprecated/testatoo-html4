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

import static org.testatoo.cartridge.html4.element.HtmlElementType.Area;

/**
 * This class allows the testing of the "area" element properties for html4.
 * Area is a region of a client-side image map, used in conjunction with map to map links to certain regions of an image.
 *
 * @author dev@testatoo.org
 * @see <a href="http://www.w3.org/TR/html401/struct/objects.html#edef-AREA"> "area" specification </a>
 */

public final class Area extends Component implements Coreattrs, I18n, Container {

    private CoreAttributeSupport coreAttributeSupport;
    private I18nAttributeSupport i18nAttributeSupport;
    private AttributeSupport attributeSupport;

    /**
     * Class constructor specifying the evaluator to use and the id of the "area" element we want to test.
     *
     * @param evaluator a UI Test engine specific html evaluator
     * @param id        the id (unique) of the "area" element
     * @throws ComponentException if the given id does not correspond to a "area" element
     */
    public Area(HtmlEvaluator evaluator, String id) {
        super(evaluator, id);
        this.evaluator = evaluator;

        coreAttributeSupport = new CoreAttributeSupport(evaluator);
        i18nAttributeSupport = new I18nAttributeSupport(evaluator);
        attributeSupport = new AttributeSupport(evaluator);
        if (evaluator.htmlElementType(id) != Area) {
            throw new ComponentException("The component with id=" + id + " is not a " + Area + " but a " + evaluator.htmlElementType(id));
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
     * To know if the area contains a given component.
     *
     * @param component the component we want to know if contained in the area
     * @return True if the component is contained in the area
     */
    public Boolean contains(Component... component) {
        return evaluator.contains(this, component);
    }

    /**
     * To get the shape attribute of the "area" element.
     * The value can be rect (rectangular), circle (circular), poly (polygonal) or default.
     *
     * @return the shape of the area     *
     * @see <a href="http://www.w3.org/TR/html401/struct/objects.html#adef-shape">W3C recommendation</a>
     */
    public Shape shape() {
        return attributeSupport.shape(this);
    }

    /**
     * To get the coords attribute of the "area" element.
     * Coords can be used to specify the pixel coordinates of the area.
     * For rectangular shapes, this is a comma-separated list of four values for left, top, right and bottom (eg. coords="0,0,60,70").
     * For circular shapes this is a comma-separated list of three values for left, top and radius (eg. coords="100,70,25").
     * For polygonal shapes, this is a comma-separated list containing an even number of values, specifying the left and top of each point of the shape (eg. coords="0,0,20,20,55,75,50,100").
     *
     * @return the coords of the area     *
     * @see <a href="http://www.w3.org/TR/html401/struct/objects.html#adef-coords">W3C recommendation</a>
     */
    public String coords() {
        return attributeSupport.coords(this);
    }

    /**
     * To get the href attribute of the "area" element.
     * Href can be used to specify the target of the area link.
     *
     * @return the href of the area
     * @see <a href="http://www.w3.org/TR/html401/struct/links.html#adef-href">W3C recommendation</a>
     */
    public String href() {
        return attributeSupport.href(this);
    }

    /**
     * To get the alt attribute of the "area" element.
     * For user agents that cannot display images, forms, or applets, this attribute specifies alternate text.
     *
     * @return the alt of the area
     * @see <a href="http://www.w3.org/TR/html401/struct/objects.html#adef-alt">W3C recommendation</a>
     */
    public String alt() {
        return attributeSupport.alt(this);
    }

    /**
     * To get the tabindex attribute of the "area" element.
     * Tabindex can be used to specify where the area appears in the tab order of the page.
     *
     * @return the tabindex of the area
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-tabindex">W3C recommendation</a>
     */
    public int tabindex() {
        return attributeSupport.tabindex(this);
    }

    /**
     * To get the accesskey attribute of the "area" element.
     * Accesskey can be used to associate a keyboard shortcut to the area.
     *
     * @return the tabindex of the area
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-accesskey">W3C recommendation</a>
     */
    public String accesskey() {
        return attributeSupport.accesskey(this);
    }

    /**
     * To know if the component is visible
     * Always return false (not visible element)
     *
     * @return always return false
     */
    @Override
    public Boolean isVisible() {
        return false;
    }

    /**
     * To get the string describing the area.
     *
     * @return string describing the area
     */
    public String toString() {
        return super.toString() + ", title:" + title() + ", href:" + href();
    }
}

