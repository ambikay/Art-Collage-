/*************************************************************************
 *  Compilation:  javac ArtCollage.java
 *  Execution:    java ArtCollage Flo2.jpeg
 *
 *  @author:  
 *
 *************************************************************************/

import java.awt.Color;

public class ArtCollage {

    // The orginal picture
    private Picture original;

    // The collage picture
    private Picture collage;

    // The collage Picture consists of collageDimension X collageDimension tiles
    private int collageDimension;

    // A tile consists of tileDimension X tileDimension pixels
    private int tileDimension;
    
    /*
     * One-argument Constructor
     * 1. set default values of collageDimension to 4 and tileDimension to 100
     * 2. initializes original with the filename image
     * 3. initializes collage as a Picture of tileDimension*collageDimension x tileDimension*collageDimension, 
     *    where each pixel is black (see all constructors for the Picture class).
     * 4. update collage to be a scaled version of original (see scaling filter on Week 9 slides)
     *
     * @param filename the image filename
     */
    public ArtCollage (String filename) {

        // WRITE YOUR CODE HERE
        this.collageDimension = 4;
        this.tileDimension = 100; 
        this.original = new Picture(filename);

        this.collage = new Picture(this.tileDimension*this.collageDimension, this.tileDimension*this.collageDimension);
        for(int column = 0; column < this.tileDimension*this.collageDimension; column ++){the b
            for(int row = 0; row < this.tileDimension*this.collageDimension; row ++){
                int columnOne = column * this.original.width() / (this.collageDimension*this.tileDimension);
                int rowOne = row * this.original.height() / (this.collageDimension*this.tileDimension);
                Color color = this.original.get(columnOne, rowOne);
                this.collage.set(column, row, color);
            }
        }
        
    }

    /*
     * Three-arguments Constructor
     * 1. set default values of collageDimension to cd and tileDimension to td
     * 2. initializes original with the filename image
     * 3. initializes collage as a Picture of tileDimension*collageDimension x tileDimension*collageDimension, 
     *    where each pixel is black (see all constructors for the Picture class).
     * 4. update collage to be a scaled version of original (see scaling filter on Week 9 slides)
     *
     * @param filename the image filename
     */
    public ArtCollage (String filename, int td, int cd) {

        // WRITE YOUR CODE HERE
        this.collageDimension = cd; 
        this.tileDimension = td;
        this.original = new Picture(filename);
        this.collage = new Picture(this.collageDimension*this.tileDimension, this.tileDimension*this.collageDimension);
        for(int column = 0; column < this.tileDimension*this.collageDimension; column++){
            for(int row = 0; row < this.collageDimension*this.tileDimension; row++){
                int columnOne = column * this.original.width() / (this.collageDimension* this.tileDimension);
                int rowOne = row * this.original.height() / (this.collageDimension * this.tileDimension);
                Color color = this.original.get(columnOne, rowOne);
                this.collage.set(column, row, color);
            }
        }
    }

    /*
     * Returns the collageDimension instance variable
     *
     * @return collageDimension
     */
    public int getCollageDimension() {

        // WRITE YOUR CODE HERE
        return this.collageDimension;
    }

    /*
     * Returns the tileDimension instance variable
     *
     * @return tileDimension
     */
    public int getTileDimension() {

        // WRITE YOUR CODE HERE
        return this.tileDimension;
    }

    /*
     * Returns original instance variable
     *
     * @return original
     */
    public Picture getOriginalPicture() {

        // WRITE YOUR CODE HERE
        return this.original;
    }

    /*
     * Returns collage instance variable
     *
     * @return collage
     */
    public Picture getCollagePicture() {

        // WRITE YOUR CODE HERE
        return this.collage; 
        
    }
    
    /*
     * Display the original image
     * Assumes that original has been initialized
     */
    public void showOriginalPicture() {

        // WRITE YOUR CODE HERE
        this.original.show();
    }

    /*
     * Display the collage image
     * Assumes that collage has been initialized
     */
    public void showCollagePicture() {

        // WRITE YOUR CODE HERE
        this.collage.show();
    }

    /*
     * Replaces the tile at collageCol,collageRow with the image from filename
     * Tile (0,0) is the upper leftmost tile
     *
     * @param filename image to replace tile
     * @param collageCol tile column
     * @param collageRow tile row
     */
    public void replaceTile (String filename,  int collageCol, int collageRow) {

        // WRITE YOUR CODE HERE
       Picture pic = new Picture(filename.toString());
       //int height = this.tileDimension;
       //int width = this.tileDimension;

       //Picture scale = new Picture(width, height);

        for(int column = 0; column < this.tileDimension; column++){
            for(int row = 0; row < this.tileDimension; row++){
                int columnOne = column * pic.width() / (this.tileDimension);
                int rowOne = row * pic.height() / (this.tileDimension);
                Color color = pic.get(columnOne, rowOne);
                this.collage.set(column + (collageCol*this.tileDimension), row + (collageRow*this.tileDimension), color);
                
            }
        }

        
    }
    
    
    /*
     * Makes a collage of tiles from original Picture
     * original will have collageDimension x collageDimension tiles, each tile
     * has tileDimension X tileDimension pixels
     */
    public void makeCollage () {

        // WRITE YOUR CODE HERE
        for(int i = 0; i < this.collageDimension; i++){
            int count = i*this.tileDimension;
            for(int j = 0; j < this.collageDimension; j++){
                int countTwo = j*this.tileDimension;
            for(int column = 0; column < this.tileDimension; column ++){
                for(int row = 0; row < this.tileDimension; row ++){
                    int columnOne = column * this.original.width() / (this.tileDimension);
                    int rowOne = row * this.original.height() / (this.tileDimension);
                    Color color = this.original.get(columnOne, rowOne);
                    this.collage.set((column + count), (row + countTwo), color);
                }
            }
        }

        }
    }

    /*
     * Colorizes the tile at (collageCol, collageRow) with component 
     * (see CS111 Week 9 slides, the code for color separation is at the 
     *  book's website)
     *
     * @param component is either red, blue or green
     * @param collageCol tile column
     * @param collageRow tile row
     */
    public void colorizeTile (String component,  int collageCol, int collageRow) {

        // WRITE YOUR CODE HERE
        int count = 0;
        Color color1;
        for(int col = 0; col < this.tileDimension; col ++){
            for(int ro = 0; ro < this.tileDimension; ro++){
                Color color = this.collage.get(collageCol*this.tileDimension +col, collageRow*this.tileDimension +ro); //fix this
                if(component.equals("green")){
                    count = color.getGreen();
                    color1 = new Color(0, count, 0);
                    this.collage.set((collageCol*this.tileDimension) + col, (collageRow*this.tileDimension) + ro, color1);
                }else if(component.equals("blue")){
                    count = color.getBlue();
                    color1 = new Color(0, 0, count);
                    this.collage.set((collageCol*this.tileDimension) + col, (collageRow*this.tileDimension) + ro, color1);
                }else if(component.equals("red")){
                    count = color.getRed();
                    color1 = new Color(count, 0, 0);
                    this.collage.set((collageCol*this.tileDimension) + col, (collageRow*this.tileDimension) + ro, color1);
                }
                //this.collage.set((collageCol*this.tileDimension) + col, (collageRow*this.tileDimension) + ro, color1);
            }
        }
    }
    

    /*
     * Grayscale tile at (collageCol, collageRow)
     * (see CS111 Week 9 slides, the code for luminance is at the book's website)
     *
     * @param collageCol tile column
     * @param collageRow tile row
     */

    public void grayscaleTile (int collageCol, int collageRow) {

        // WRITE YOUR CODE HERE
       for(int col = 0; col < this.tileDimension; col++){
           for(int ro = 0; ro < this.tileDimension; ro++){
               Color color = this.collage.get(col +(collageCol*this.tileDimension), ro + (collageRow*this.tileDimension));
               Color gray = Luminance.toGray(color);
               this.collage.set((collageCol*this.tileDimension) + col, (collageRow*this.tileDimension) + ro, gray);
           }
       }
    }


    /*
     *
     *  Test client: use the examples given on the assignment description to test your ArtCollage
     */
    public static void main (String[] args) {
       /*ArtCollage art = new ArtCollage(args[0], 200, 3); 
       art.makeCollage();
       art.replaceTile(args[1], 1, 1);
       art.showCollagePicture();  */
      /* ArtCollage art = new ArtCollage(args[0], 200, 3);
       art.makeCollage();
       art.replaceTile(args[1],1,1);
       art.showCollagePicture();*/
       ArtCollage art = 
       new ArtCollage(args[0], 200, 3);

       art.makeCollage();

      // Colorize tile at col 2, row 2 
      // to only show the red component
      art.colorizeTile("red",2,2);
      art.showCollagePicture();
        
        
    }
}

