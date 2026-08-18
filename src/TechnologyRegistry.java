import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TechnologyRegistry {
    private static final List<Technology> technologies = new ArrayList<>();

    private TechnologyRegistry() {
    }

    static {
        initializeTechnologies();
    }


        private static void initializeTechnologies() {
            technologies.add(new Technology("WordPress",
                    List.of(
                            new TechnologySignature("wp-content", 10),
                            new TechnologySignature("wp-includes", 10),
                            new TechnologySignature("wp-json", 8),
                            new TechnologySignature("wp-emoji-release.min.js", 8)
                    )
            ));

            technologies.add(new Technology("Shopify",
                    List.of(
                            new TechnologySignature("cdn.shopify.com", 10),
                            new TechnologySignature("Shopify.theme", 10)
                    )));

            technologies.add(new Technology("Bootstrap",
                    List.of(
                            new TechnologySignature("bootstrap.min.css", 6),
                            new TechnologySignature("bootstrap.css", 6)
                    )));

            technologies.add(new Technology("jQuery",
                    List.of(
                            new TechnologySignature("jquery.min.js", 5),
                            new TechnologySignature("jquery.js", 5),
                            new TechnologySignature("code.jquery.com/jquery", 8)
                    )));

            technologies.add(new Technology("OpenAI",
                    List.of(
                            new TechnologySignature("api.openai.com", 10),
                            new TechnologySignature("platform.openai.com", 8)
                    )));

            technologies.add(new Technology("React",
                    List.of(
                            new TechnologySignature("react.production.min.js", 8),
                            new TechnologySignature("react.development.js", 8),
                            new TechnologySignature("react-dom", 7),
                            new TechnologySignature("data-reactroot", 10),
                            new TechnologySignature("_REACT_DEVTOOLS_GLOBAL_HOOK_", 10)
                    )));

            technologies.add(new Technology("Vue.js",
                    List.of(
                            new TechnologySignature("vue.min.js", 8),
                            new TechnologySignature("vue.js", 7),
                            new TechnologySignature("vue.runtime", 9)
                    )));

            technologies.add(new Technology("Angular",
                    List.of(
                            new TechnologySignature("ng-version", 10),
                            new TechnologySignature("angular.min.js", 8),
                            new TechnologySignature("angular.js", 7)
                    )));

            technologies.add(new Technology("Next.js",
                    List.of(
                            new TechnologySignature("/_next/", 10),
                            new TechnologySignature("_NEXT_DATA_", 10),
                            new TechnologySignature("next/static", 10)
                    )));

            technologies.add(new Technology("Tailwind CSS",
                    List.of(
                            new TechnologySignature("cdn.tailwindcss.com", 8),
                            new TechnologySignature("tailwind.min.css", 8)
                    )));

            technologies.add(new Technology("Font Awesome",
                    List.of(
                            new TechnologySignature("fontawesome-free/css", 6),
                            new TechnologySignature("font-awesome/css", 6),
                            new TechnologySignature("cdnjs.cloudflare.com/ajax/libs/font-awesome", 8)
                    )));

            technologies.add(new Technology("Google Analytics",
                    List.of(
                            new TechnologySignature("googletagmanager.com/gtag/js", 8),
                            new TechnologySignature("google-analytics.com/analytics.js", 8),
                            new TechnologySignature("gtag('config'", 8)
                    )));

            technologies.add(new Technology("Google Tag Manager",
                    List.of(
                            new TechnologySignature("googletagmanager.com/gtm.js", 10),
                            new TechnologySignature("GTM-", 6)
                    )));

            technologies.add(new Technology("Drupal",
                    List.of(
                            new TechnologySignature("drupalSettings", 10),
                            new TechnologySignature("Drupal.settings", 10),
                            new TechnologySignature("sites/default/", 8),
                            new TechnologySignature("sites/all/", 8)
                    )));

            technologies.add(new Technology("Joomla",
                    List.of(
                            new TechnologySignature("Joomla!", 10),
                            new TechnologySignature("/media/system/js/", 8),
                            new TechnologySignature("/components/com_", 8)
                    )));

            technologies.add(new Technology("Wix",
                    List.of(
                            new TechnologySignature("wixstatic.com", 10),
                            new TechnologySignature("static.wixstatic.com", 10)
                    )));

            technologies.add(new Technology("Squarespace",
                    List.of(
                            new TechnologySignature("static1.squarespace.com", 10),
                            new TechnologySignature("squarespace.com", 8)
                    )));

            technologies.add(new Technology("Webflow",
                    List.of(
                            new TechnologySignature("data-wf-site", 10),
                            new TechnologySignature("webflow.css", 7),
                            new TechnologySignature("webflow.js", 7)
                    )));

            technologies.add(new Technology("Elementor",
                    List.of(
                            new TechnologySignature("elementor-frontend", 10),
                            new TechnologySignature("elementor/assets/", 10),
                            new TechnologySignature("elementor-icons", 10)
                    )));

            technologies.add(new Technology("Google Fonts",
                    List.of(
                            new TechnologySignature("fonts.googleapis.com/css", 5),
                            new TechnologySignature("fonts.gstatic.com", 1)
                    )));

            technologies.add(new Technology("reCAPTCHA",
                    List.of(
                            new TechnologySignature("google.com/recaptcha", 8),
                            new TechnologySignature("gstatic.com/recaptcha", 8),
                            new TechnologySignature("grecaptcha", 5)
                    )));

            technologies.add(new Technology("Svelte",
                    List.of(
                            new TechnologySignature("svelte/internal", 10),
                            new TechnologySignature("svelte/store", 10),
                            new TechnologySignature("svelte-routing", 8)
                    )));

            technologies.add(new Technology("Nuxt.js",
                    List.of(
                            new TechnologySignature("window.__NUXT__", 10),
                            new TechnologySignature("/_nuxt/", 10),
                            new TechnologySignature("nuxt.config", 8)
                    )));

            technologies.add(new Technology("Astro",
                    List.of(
                            new TechnologySignature("astro-island", 10),
                            new TechnologySignature("astro:assets", 10),
                            new TechnologySignature("astro/client", 8)
                    )));

            technologies.add(new Technology("Laravel",
                    List.of(
                            new TechnologySignature("laravel_session", 10),
                            new TechnologySignature("XSRF-TOKEN", 6),
                            new TechnologySignature("/vendor/laravel/", 10)
                    )));

            technologies.add(new Technology("PHP",
                    List.of(
                            new TechnologySignature("PHPSESSID", 8)
                    )));

            technologies.add(new Technology("Django",
                    List.of(
                            new TechnologySignature("csrftoken=", 6),
                            new TechnologySignature("csrftoken", 4),
                            new TechnologySignature("__admin_media_prefix__", 10),
                            new TechnologySignature("django.contrib", 10)
                    )));

            technologies.add(new Technology("Cloudflare",
                    List.of(
                            new TechnologySignature("cloudflareinsights.com", 8),
                            new TechnologySignature("cf-ray", 10)
                    )));

            technologies.add(new Technology("Matomo",
                    List.of(
                            new TechnologySignature("matomo.js", 10),
                            new TechnologySignature("_paq.push", 10),
                            new TechnologySignature("matomo.php", 8)
                    )));

            technologies.add(new Technology("WooCommerce",
                    List.of(
                            new TechnologySignature("woocommerce", 10),
                            new TechnologySignature("wc-ajax", 8),
                            new TechnologySignature("woocommerce/assets/", 10)
                    )));

            technologies.add(new Technology("Magento",
                    List.of(
                            new TechnologySignature("Magento_", 10),
                            new TechnologySignature("mage/cookies", 8),
                            new TechnologySignature("Magento_Ui", 10)
                    )));

            technologies.add(new Technology("PrestaShop",
                    List.of(
                            new TechnologySignature("prestashop", 10),
                            new TechnologySignature("PrestaShop", 10),
                            new TechnologySignature("/modules/ps_", 8)
                    )));

            technologies.add(new Technology("Ghost",
                    List.of(
                            new TechnologySignature("ghost.org", 8),
                            new TechnologySignature("ghost.io", 8),
                            new TechnologySignature("ghost-url", 7)
                    )));

            technologies.add(new Technology("TYPO3",
                    List.of(
                            new TechnologySignature("typo3", 8),
                            new TechnologySignature("typo3conf/", 10),
                            new TechnologySignature("TYPO3", 10)
                    )));

            technologies.add(new Technology("Ember.js",
                    List.of(
                            new TechnologySignature("ember.js", 8),
                            new TechnologySignature("EmberENV", 10),
                            new TechnologySignature("data-ember-action", 10)
                    )));

            technologies.add(new Technology("Backbone.js",
                    List.of(
                            new TechnologySignature("backbone.js", 8),
                            new TechnologySignature("Backbone.View", 8),
                            new TechnologySignature("Backbone.Model", 8)
                    )));

            technologies.add(new Technology("Alpine.js",
                    List.of(
                            new TechnologySignature("alpinejs", 8),
                            new TechnologySignature("x-data", 10),
                            new TechnologySignature("x-bind:", 8)
                    )));

            technologies.add(new Technology("Preact",
                    List.of(
                            new TechnologySignature("preact", 8),
                            new TechnologySignature("preact.min.js", 10),
                            new TechnologySignature("preact.js", 10)
                    )));

            technologies.add(new Technology("Three.js",
                    List.of(
                            new TechnologySignature("three.min.js", 10),
                            new TechnologySignature("three.js", 10),
                            new TechnologySignature("THREE.", 8)
                    )));

            technologies.add(new Technology("GSAP",
                    List.of(
                            new TechnologySignature("gsap.min.js", 10),
                            new TechnologySignature("gsap.js", 10),
                            new TechnologySignature("gsap.to(", 8)
                    )));

            technologies.add(new Technology("ASP.NET",
                    List.of(
                            new TechnologySignature("__VIEWSTATE", 10),
                            new TechnologySignature("__EVENTVALIDATION", 10),
                            new TechnologySignature("aspNetHidden", 8)
                    )));

            technologies.add(new Technology("Materialize CSS",
                    List.of(
                            new TechnologySignature("materialize.min.css", 10),
                            new TechnologySignature("materialize.css", 10),
                            new TechnologySignature("materialize.min.js", 8)
                    )));

            technologies.add(new Technology("Bulma",
                    List.of(
                            new TechnologySignature("bulma.min.css", 10),
                            new TechnologySignature("bulma.css", 10),
                            new TechnologySignature("bulma-", 6)
                    )));

            technologies.add(new Technology("Foundation",
                    List.of(
                            new TechnologySignature("foundation.min.css", 10),
                            new TechnologySignature("foundation.css", 10),
                            new TechnologySignature("foundation.min.js", 8)
                    )));

            technologies.add(new Technology("HubSpot",
                    List.of(
                            new TechnologySignature("js.hs-scripts.com", 10),
                            new TechnologySignature("js.hs-analytics.net", 8),
                            new TechnologySignature("hsforms.com", 8)
                    )));
    }


    public static List<Technology> getAllTechnologies() {
        return Collections.unmodifiableList(technologies);
    }

}
