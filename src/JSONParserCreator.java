/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author jlnabais
 */
public class JSONParserCreator extends AbstractParserCreator{

    @Override
    public Parser createParser() {
        ParserJSON parser = new ParserJSON();
        return parser;
    }

}
