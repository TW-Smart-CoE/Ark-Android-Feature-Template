@file:Suppress("PackageNaming")

package package_name.feature.feature_name

import android.widget.Toast
import com.thoughtworks.ark.router.annotation.ServiceImpl
import package_name.feature.feature_name.api.TempApi
import zlc.season.claritypotion.ClarityPotion

@ServiceImpl
class TempApiImpl : TempApi {
    override fun helloWorld() {
        Toast.makeText(ClarityPotion.context, "hello world", Toast.LENGTH_SHORT).show()
    }
}
