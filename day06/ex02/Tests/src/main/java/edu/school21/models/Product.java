package edu.school21.models;

public class Product {
    Long identifier;
    String names;
    Long price;

    public Product(Long identifier, String names, Long price) {
        this.identifier = identifier;
        this.names = names;
        this.price = price;
    }

    public Long getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Long identifier) {
        this.identifier = identifier;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (getIdentifier() != null ? !getIdentifier().equals(product.getIdentifier()) : product.getIdentifier() != null)
            return false;
        if (getNames() != null ? !getNames().equals(product.getNames()) : product.getNames() != null) return false;
        return getPrice() != null ? getPrice().equals(product.getPrice()) : product.getPrice() == null;
    }

    @Override
    public int hashCode() {
        int result = getIdentifier() != null ? getIdentifier().hashCode() : 0;
        result = 31 * result + (getNames() != null ? getNames().hashCode() : 0);
        result = 31 * result + (getPrice() != null ? getPrice().hashCode() : 0);
        return result;
    }
}
