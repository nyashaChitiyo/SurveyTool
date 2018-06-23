package com.codel.zw.saint_mobile_go.pojo;

public class SalesQuestionairePojo {
        public String did_you_like_product,product_you_liked;
        public String have_you_used_product;

        public String getHave_you_used_product() {
            return have_you_used_product;
        }

        public SalesQuestionairePojo(String did_you_like_product, String product_you_liked, String have_you_used_product) {
            this.did_you_like_product = did_you_like_product;
            this.product_you_liked = product_you_liked;
            this.have_you_used_product = have_you_used_product;
        }

        public void setHave_you_used_product(String have_you_used_product) {
            this.have_you_used_product = have_you_used_product;
        }

        public SalesQuestionairePojo(String did_you_like_product, String product_you_liked) {
            this.did_you_like_product = did_you_like_product;
            this.product_you_liked = product_you_liked;
        }

        public String getDid_you_like_product() {
            return did_you_like_product;
        }

        public void setDid_you_like_product(String did_you_like_product) {
            this.did_you_like_product = did_you_like_product;
        }

        public String getProduct_you_liked() {
            return product_you_liked;
        }

        public void setProduct_you_liked(String product_you_liked) {
            this.product_you_liked = product_you_liked;
        }
}
