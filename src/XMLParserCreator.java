/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author jlnabais
 */
public class XMLParserCreator extends AbstractParserCreator{

    @Override
    public Parser createParser() {
        ParserXML parser = new ParserXML();
        return parser;
    }

}
