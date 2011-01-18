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
import org.testatoo.core.Selection;
import org.testatoo.core.component.Component;
import org.testatoo.core.nature.Container;

import static org.testatoo.cartridge.html4.element.HtmlElementType.Object;
import static org.testatoo.cartridge.html4.element.HtmlElementType.Undefined;

/**
 * This class allows the testing of the "object" element properties for html4.
 * Object is an embedded multimedia object, often used in conjunction with param.
 *
 * @author dev@testatoo.org
 * @see <a href="http://www.w3.org/TR/html401/struct/objects.html#edef-OBJECT"> object specification </a>
 */

public final class Object extends Component implements Coreattrs, I18n, Container {

    private CoreAttributeSupport coreAttributeSupport;
    private I18nAttributeSupport i18nAttributeSupport;
    private AttributeSupport attributeSupport;
    private HtmlEvaluator evaluator;

    /**
     * Class constructor specifying the evaluator to use and the id of the "object" element we want to test.
     *
     * @param evaluator a UI Test engine specific html evaluator
     * @param id        the id (unique) of the "object" element
     * @throws ComponentException if the given id does not correspond to a "object" element
     */
    public Object(HtmlEvaluator evaluator, String id) {
        super(evaluator, id);
        this.evaluator = evaluator;

        coreAttributeSupport = new CoreAttributeSupport(evaluator);
        i18nAttributeSupport = new I18nAttributeSupport(evaluator);
        attributeSupport = new AttributeSupport(evaluator);
        if (evaluator.htmlElementType(id) != Object && evaluator.htmlElementType(id) != Undefined) {
            throw new ComponentException("The component with id=" + id + " is not a " + Object + " but a " + evaluator.htmlElementType(id));
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
     * To know if the object contains all the given components.
     *
     * @param components components we want to know if contained in the object
     * @return True if all the components is contained in the object
     */
    public Boolean contains(Component... components) {
        return evaluator.contains(this, components);
    }

    /**
     * To get the classid attribute of the object.
     * Classid can be used to specify the location of the object in the form of a URL or Windows Registry location.
     *
     * @return the classid of the "object" element
     * @see <a href="http://www.w3.org/TR/html401/struct/objects.html#adef-classid">W3C recommendation</a>
     */
    public String classid() {
        return attributeSupport.classid(this);
    }

    /**
     * To get the codebase attribute of the object.
     * Codebase can be used to specify the base location from which relative URLs specified in the classid,
     * data and archive attributes should be taken.
     *
     * @return the codebase of the "object" element
     * @see <a href="http://www.w3.org/TR/html401/struct/objects.html#adef-codebase-OBJECT">W3C recommendation</a>
     */
    public String codebase() {
        return attributeSupport.codebase(this);
    }

    /**
     * To get the data attribute of the object.
     * Data can be used to specify the location of the data for the object in the form of a URL.
     *
     * @return the data of the "object" element
     * @see <a href="http://www.w3.org/TR/html401/struct/objects.html#adef-data">W3C recommendation</a>
     */
    public String data() {
        return attributeSupport.data(this);
    }

    /**
     * To get the type attribute of the object.
     * Type can be used to specify the content type of the data specified by the data attribute.
     *
     * @return the type of the "object" element
     * @see <a href="http://www.w3.org/TR/html401/struct/objects.html#adef-type-OBJECT">W3C recommendation</a>
     */
    public String type() {
        return attributeSupport.type(this);
    }

    /**
     * To get the archive attribute of the object.
     * Archive can be used to specify resources relevant to the object.
     * The value should be a URL or a number of URLs separated by spaces.
     *
     * @return the archive of the "object" element
     * @see <a href="http://www.w3.org/TR/html401/struct/objects.html#adef-archive-OBJECT">W3C recommendation</a>
     */
    public String archive() {
        return attributeSupport.archive(this);
    }

    /**
     * To get the codetype attribute of the object.
     * Codetype can be used to specify the content type of the object.
     *
     * @return the codetype of the "object" element
     * @see <a href="http://www.w3.org/TR/html401/struct/objects.html#adef-codetype">W3C recommendation</a>
     */
    public String codetype() {
        return attributeSupport.codetype(this);
    }

    /**
     * To get the standby attribute of the object.
     * Standby can be used to specify text that will be displayed while the object is loading.
     *
     * @return the standby of the "object" element
     * @see <a href="http://www.w3.org/TR/html401/struct/objects.html#adef-standby">W3C recommendation</a>
     */
    public String standby() {
        return attributeSupport.standby(this);
    }

    /**
     * To get the height attribute of the object.
     *
     * @return the height (in pixels) of the "object" element
     * @see <a href="http://www.w3.org/TR/html401/struct/objects.html#adef-height-IMG">W3C recommendation</a>
     */
    public String height() {
        return attributeSupport.height(this);
    }

    /**
     * To get the width attribute of the object.
     *
     * @return the width (in pixels) of the "object" element
     * @see <a href="http://www.w3.org/TR/html401/struct/objects.html#adef-width-IMG">W3C recommendation</a>
     */
    public String width() {
        return attributeSupport.width(this);
    }

    /**
     * To get the usemap attribute of the object.
     *
     * @return the usemap of the "object" element
     * @see <a href="http://www.w3.org/TR/html401/struct/objects.html#adef-usemap">W3C recommendation</a>
     */
    public String usemap() {
        return attributeSupport.usemap(this);
    }

    /**
     * To get the name attribute of the object.
     * Name can be used to specify a name by which the object can be referenced.
     *
     * @return the name of the "object" element
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-name-INPUT">W3C recommendation</a>
     */
    public String name() {
        return attributeSupport.name(this);
    }

    /**
     * To get the different parameters of the object.
     *
     * @return the list of parameters of the "object" element
     */
    public Selection<Param> params() {
        return evaluator.params(this);
    }


}
